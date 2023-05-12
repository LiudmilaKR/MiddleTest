import view
import model

def start():
    view.hello()
    while (True):
        point = view.menu()
        menu_handler(point)

def menu_handler(inp: int):
    path = 'Task1Python/nnotes.txt'
    match inp:
        case 1: # 1.Вывести список всех заметок.
            loaded_notes = model.load_from_file(path)
            view.show_notes(loaded_notes)
            # При чтении списка заметок реализовать фильтрацию по дате.
        case 2: # 2.Создать новую заметку.
            last_id = model.take_last_id(path)
            created_note = view.create_note(last_id)
            model.load_to_file_str(path, created_note)
            view.change_status_create_note()
        case 3: # 3.Редактировать заметку.
            id_for_change = view.choose_note()
            list_for_change = model.find_data(path, id_for_change)
            model.del_data(path, id_for_change)
            changed_str = view.change_note(list_for_change)
            model.load_to_file_str(path, changed_str)
            view.change_status_reduct_note(id_for_change)
        case 4: # 4.Удалить заметку.
            id_for_del = view.choose_note()
            model.del_data(path, id_for_del)
            view.change_status_del_note(id_for_del)
        case 5: # 5.Выход.
            view.exit_menu()
        case _:
            view.bad_input()
        




 
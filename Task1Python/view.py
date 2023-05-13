import datetime

def menu() -> int:
    print('Выберите команду =>')
    menu_list = ['Вывести список всех заметок.', 'Создать новую заметку.', 'Редактировать заметку.',\
        'Удалить заметку.', 'Выход.']
    for i in range(len(menu_list)):
        print(f'   {i + 1}.{menu_list[i]}')
    while (True):
        try:
            point = int(input())
            if type(point) == int:   
                return point
        except:
            print('Вы ввели не число! Попробуйте ещё раз!')

def hello():
    print('Начало работы.\n')
    
def choose_file() -> str:
    opt = int(input('Выберите файл заметок: 1 - txt, 2 - csv => '))
    if opt == 1: return 'Task1Python/nnotes.txt'
    else: return 'Task1Python/nnotes.csv'

def show_notes(load_data: list):
    if load_data == []:
        print('Ничего не выгрузилось. Видимо, какая-то ошибка.')
    else:
        for item in load_data:
            if item != "":
                item_list = item.split(';')
                if item_list[2] == 'None':
                    print(f'id={item_list[0]} заметка от {item_list[1]} "{item_list[3]}":\n\t{item_list[4]}')
                else:
                    print(f'id={item_list[0]} заметка от {item_list[1]} (скорректирована {item_list[2]}) ' + 
                          f'"{item_list[3]}":\n\t{item_list[4]}')
        print()

def create_note(id_num: int) -> str:
    # cr_id = input('Введите id => ')
    cr_id = str(id_num + 1);
    cr_date = str(datetime.datetime.today())[:10]
    cr_title = input('Введите заголовок => ')
    cr_text = input('Введите текст => ')
    return f'{cr_id};{cr_date};{None};{cr_title};{cr_text}'
         
def choose_note() -> str:
    return input('Введите id заметки => ')

def change_note(data_for_change: list) -> str:
    change_date = str(datetime.datetime.today())[:10]
    opt1 = int(input('Если хотите изменить заголовок заметки - 1, нет - 0 => '))
    if opt1 == 1: cr_title = input('Введите новый заголовок => ')
    else: cr_title = data_for_change[3]
    opt2 = int(input('Если хотите изменить текст заметки - 1, нет - 0 => '))
    if opt2 == 1: cr_text = input('Введите новый текст => ')
    else: cr_title = data_for_change[4]
    return f'{data_for_change[0]};{data_for_change[1]};{change_date};{cr_title};{cr_text}\n'

def change_status_create_note():
    print('Новая заметка создана и загружена в файл.\n')

def change_status_reduct_note(red_id: str):
    print(f'Заметка c id={red_id} отредактирована.\n')
    
def change_status_del_note(del_id: str):
    print(f'Заметка c id={del_id} удалена.\n')

def exit_menu():
    print('Завершение работы.')
    exit()

def bad_input():
    print('Такого пункта в меню нет! Попробуйте ещё раз!\n')
    
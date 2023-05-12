def load_from_file(path: str) -> list:
    try:
        with open(path, 'r', encoding='utf-8') as fd:
            # data_list = fd.readlines()
            # data_list = [item.replace('\n', '') for item in data_list]
            data_list = fd.read().split('\n')
        return data_list
    except:
        return []

def take_last_id(path: str) -> int:
    data_list = load_from_file(path)
    list_id = []
    for item in data_list:
        list_id.append(int(item[0]))
    # print(list_id)
    list_id.sort()
    # list_id.reverse()
    # print(list_id)
    return list_id[-1]
# print(take_last_id('Task1Python/nnotes.txt'))    
 
def load_to_file_str(path: str, data_for_load: str):
    try:
        with open(path, 'a', encoding='utf-8') as fd:
            fd.write('\n' + data_for_load)
    except:
        None

def load_to_file_list(path: str, data_for_load: list):
    try:
        with open(path, 'w', encoding='utf-8') as fd:
            for i in range(len(data_for_load) - 1):
                fd.write(data_for_load[i] + '\n')
            fd.write(data_for_load[len(data_for_load) - 1])
    except:
        None      

def del_data(path: str, data_for_del: str):
    loaded_data = load_from_file(path)
    for item in loaded_data:
        if item[0] == data_for_del:
            loaded_data.remove(item)
    load_to_file_list(path, loaded_data)
    
def find_data(path: str, data_for_find: str) -> list:
    loaded_data = load_from_file(path)
    for item in loaded_data:
        if item[0] == data_for_find:
            return item.split(';')
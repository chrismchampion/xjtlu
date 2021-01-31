class MyObject:

    obj_name = ''

    def __init__(self, p_name):
        self.obj_name = p_name

    def get_name(self):
        return self.obj_name

obj_list = list()

obj_1 = MyObject("Node 1")
obj_2 = MyObject("Node 2")
obj_3 = MyObject("Node 3")

obj_list.append(obj_1)
obj_list.append(obj_2)
obj_list.append(obj_3)

my_dictionary = {"Node 100": "some val"}

for node in obj_list:
    key = node
    value = node.get_name()
    new_entry = {key: value}
    my_dictionary.update(new_entry)

print(my_dictionary.items())

'''my_dict = {
    'Node 1': [('Node 2', 4), ('Node 3', 2)],
    'Node 2': [('Node 3', 5), ('Node 1', 4)],
    'Node 3': [('Node 1', 2), ('Node 2', 5)]
}

print(my_dict.get('Node 2'))

new_key = 'Node 4'
new_val = ('Node 1', 3)
new_entry = {new_key: new_val}

my_dict.update(new_entry)
print(my_dict.items())'''


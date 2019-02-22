class Node:
    def __init__(self, data=None):
        self.__data = data
        self.__next = None
    def __del__(self):
        print("data of {} is deleted".format(self.data))
        
    @property
    def data(self):
        return self.__data
    
    @data.setter
    def data(self,data):
        self.__data=data
        
    @property
    def next(self):
        return self.__next
    
    @next.setter
    def next(self,n):
        self.__next = n



        
class Linked_list:
    def __init__(self):
        self.head = None
        self.tail = None
        self.d_size = 0
        
    def empty(self):
        if self.d_size == 0:
            return True
        else:
            return False
        
    def size(self):
        return self.d_size
    
    def append(self, data):
        new_node = Node(data)
        
        if self.empty():
            self.head = new_node
            self.tail = new_node
            self.d_size += 1
        else:
            self.tail.next = new_node
            self.tail = new_node
            self.d_size += 1
            
    def search_target(self, target, start = 0):
        if self.empty():
            return None
        pos = 0
        cur = self.head
        if pos >= start and target == cur.data:
            return cur.data, pos
        
        while cur.next:
            pos += 1
            cur = cur.next
            if pos >= start and target == cur.data:
                return cur.data, pos
            
        return None, None
    
    def search_pos(self, pos):
        if pos > self.size() - 1:
            return None
        
        cnt = 0
        cur = self.head
        if cnt == pos:
            return cur.data
        
        while cnt < pos:
            cur = cur.next
            cnt += 1
        return cur.data
    
    def remove(self, target):
        if self.empty():
            return None
        
        bef = self.head
        cur = self.head
        
        if target == cur.data:
            if self.size() == 1:
                self.head = None
                self.tail = None
            else:
                self.head=self.head.next
            self.d_size -= 1
            return cur.data
        
            while cur.next:
                 bef = cur
                 cur = cur.next
                 if target == cur.data:
                     if cur == self.tail:
                         self.tail = bef
                     bef.next = cur.next
                     self.d_size -= 1
                     return cur.data
                    
            return None
def show_list(slist):
    if slist.empty():
        print('The list is empty')
        return
    
    for i in range(slist.size()):
        print(slist.search_pos(i),end='')

        
if __name__=="__main__":
    slist=Linked_list()
    print("데이터 개수: {}".format(slist.size()))
    show_list(slist)
    print()
    
    slist.append(3)
    slist.append(1)
    slist.append(5)
    slist.append(2)
    slist.append(10)
    slist.append(7)
    slist.append(2)
    
    print("데이터 개수: {}".format(slist.size()))
    show_list(slist)
    print('\n')
    
    data1,pos1=slist.search_target(2)
    if data1:
        print('searched data: {} at pos<{}>'.format(data1,pos1))
    else:
        print('there is no such data')
        
    data2,pos2=slist.search_target(2,pos1 + 1)
    if data2:
        print('searched data : {} at pos<{}>'.format(data2,pos2))
    else:
        print('there is no such data')

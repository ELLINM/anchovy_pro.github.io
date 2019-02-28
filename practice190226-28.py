from binary_tree import *

class BST:
    def __init__(self):
        self.root = None

    def get_root(self):
        return self.root

    def preorder_traverse(self, cur, f):
        if not cur:
            return


        f(cur.data)
        self.preorder_traverse(cur.left, f)
        self.preorder_traverse(cur.right, f)

    def insert(self, data):
         new_node = TreeNode()
         new_node.data = data


         cur = self.root
         if cur == None:
             self.root = new_node
             return

        while True:
            parent = cur
            if data < cur.data:
                cur = cur.left

                if not cur:
                    parent.left = new_node
                    return

            else:
                cur = cur.right
                if not cur:
                    parent.right = new_node
                    return
    

    def search(self, target):
        cur = self.root


        while cur:
            if target == cur.data:
                return cur
            elif target < cur.data:
                cur = cur.left
            elif target > cur.data:
                cur = cur.right
        return cur

    def __remove_recursion(self, cur, target):
        if cur == None:
            return None, None
        elif target < cur.data:
            cur.left, rem_node = self.__remove_recursion(cur.left, target)
        elif target > cur.data:
            cur.right, rem_node = self.__remove_recursion(cur.right, target)
        else:
            if not cur.left and not cur.right:
                rem_node = cur
                cur = None
            elif not cur.right:
                rem_node = cur
                cur = cur.left
            elif not cur.left:
                rem_node = cur
                cur = cur.right
            else:
                replace = cur.left
                while replace.right:
                    replace = replace.right
                
                cur.data, replace.data = replace.data, cur.data
                cur.left, rem_node = self.__remove_recursion(cur.left, replace.data)
        
        return cur, rem_node


if __name__ == "__main__":
    bst = BST()


    bst.insert(6)
    bst.insert(3)
    bst.insert(2)
    bst.insert(4)
    bst.insert(5)
    bst.insert(8)
    bst.insert(10)
    bst.insert(9)
    bst.insert(11)


    f = lambda x: print(x, end = ' ')

#test1
    bst.preorder_traverse(bst.get_root(), f)
    print()
#print 6 3 2 4 5 8 10 9 11
    
    def insert_node(self, node):
        cur = self.root

        if cur == None:
            self.root = node
            return

        while True:
            parent = cur

            if node.data < cur.data:
                cur = cur.left
                if not cur:
                    parent.left = node
                    return
            else:
                cur = cur.right
                if not cur:
                    parent.right = node
                    return
                
#test2 search() method                
print("searched data : {}".format(bst.search(8).data))
#print searched data :8

    node = bst.remove(6)
    node.data = 7
    bst.insert_node(node)

#test3 insert_node() method
    bst.preorder_traverse(bst.get_root(), f)
    print()
#print 5 3 2 4 8 7 10 9 11

/* Implementing a Binary Search Tree to store account objects */

// Student name : Aditya Sharma
// Student ID: 1616591

// A private nested class BSTNode to represent the nodes of the Binary Search Tree.

public class BankBST {
    

    private class BSTNode {
        public Account account; // The account stored in the node
        public int key; // key used to compare the code
        public BSTNode  left,right; // Pointers to the left and right child nodes
        

        public BSTNode(Account account) { // Constructor 
            this.account = account;
            key = account.getKey();
            right = null;
            left = null;
        }
    }
    private BSTNode root; // BSTNode set to root 




    public void Addaccount(Account newAcount){ // public method to add an account to the binary search tree
        root = AddaccountR(root, newAcount);// calls the recursive helper method AddaccountR with the root node and new account as parameters
    }

    private BSTNode AddaccountR(BSTNode cRoot, Account newAccount) { // private helper method to recursively add an account to the binary search tree
        if (cRoot == null) { // if the current node is null, then create a new node and set its account to the new account
            cRoot = new BSTNode(newAccount);
        }

        else if (newAccount.getKey() < cRoot.key){ // if the key of the new account is less than the current node's key, then recurse with the left subtree
            cRoot.left = AddaccountR(cRoot.left, newAccount);
        }

        else if (newAccount.getKey() > cRoot.key){// if the key of the new account is greater than the current node's key, then recurse with the right subtree
            cRoot.right = AddaccountR(cRoot.right, newAccount);
        }
        return cRoot;  // return the modified current node
    }


    public Account search(Account nAccount){ // public serach/find method to find Accounts in the binary serach tree 
        return searchR(root, nAccount);
    }

    private Account searchR(BSTNode cRoot, Account nAccount){ // helper recursive serach/find method 
        Account fAccount; //account found variable

        if(cRoot == null){ // If root is null, account doesn't exist
            System.out.print(nAccount.getKey() + " ");
            return null;
        }
        else if (cRoot.key==nAccount.getKey()){ // If root key matches search key, account is found
            System.out.print(cRoot.key + " ");
            return cRoot.account;
        }

        else if (nAccount.getKey() < cRoot.key){ // If search key is less than root key, search in left subtree
            System.out.print(cRoot.key + " ");
            fAccount = searchR(cRoot.left, nAccount);
        }

        else {// If search key is greater than root key, search in right subtree
            System.out.print(cRoot.key + " ");
            fAccount = searchR(cRoot.right, nAccount);
        }

        return fAccount; // Return found account, if any
    }


    // This is a private helper recursive method that removes an account from the BST. 
    // It takes a BSTNode object and an Account object as parameters.
    public void Remove(Account nAccount){ // public remove method to remove accounts from the binary serach tree
        root = RemoveR(root, nAccount);
    }

    private BSTNode RemoveR(BSTNode cRoot, Account nAccount){ // helper recursive remove function
        // If the current root is null, then return null. 

        if (cRoot == null){
            return null;
        }
        // If the key of the given account is less than the current root key, then call the RemoveR method with the left child of the current root. 
        if(nAccount.getKey() < cRoot.key){
            cRoot.left = RemoveR(cRoot.left, nAccount);
        }
        // If the key of the given account is greater than the current root key, then call the RemoveR method with the right child of the current root. 
        else if (nAccount.getKey() > cRoot.key){
            cRoot.right = RemoveR(cRoot.right, nAccount);
        }
        else{
            // If the left child of the current root is null, then return the right child. 
            if(cRoot.left == null){
                return cRoot.right;
            }
            // If the right child of the current root is null, then return the left child. 
            else if(cRoot.right ==null){
                return cRoot.left;
            }
            // If both children of the current root exist, find the minimum key in the right subtree to replace the current root. 
            else{
                // Create a temporary node and set it to the right child of the current root.
                BSTNode temporary = cRoot.right;
                // Traverse the left subtree of the temporary node until a node with a null left child is found.
                while(temporary.left != null){
                    temporary = temporary.left;
                }
                // Set the key and account of the current root to the key and account of the temporary node.
                cRoot.key = temporary.key;
                cRoot.account = temporary.account;
                 // Call the RemoveR method with the right child of the current root and the account of the temporary node to remove the temporary node.
                cRoot.right = RemoveR(cRoot.right,temporary.account);
            }
        }
        // Return the modified current root. 
        return cRoot;

    }

    // A public method to traverse the binary search tree
    public void traverseBST(){
        traverseR(root);
    }

    // A private helper method to recursively traverse the binary search tree
    private void traverseR(BSTNode cRoot){
        // If the current root is null, then return and do nothing
        if (cRoot==null){
            return;
        }

        // Traverse the left subtree of the current root
        traverseR(cRoot.left);
        // Print the current root's key and account balance
        System.out.println(cRoot.key + " " + cRoot.account.getBalance());
        // Traverse the right subtree of the current root
        traverseR(cRoot.right);


    }

}
   




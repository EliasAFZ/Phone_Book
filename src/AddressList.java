
/**
 *
 * @author Elias Afzalzada
 */
public class AddressList {

    private ListNode firstNode;
    private ListNode currentNode;

    //Constructor
    AddressList() {
        this.firstNode = null;
        this.currentNode = null;
    }

    //Method used to check if the list is empty
    public boolean isEmpty() {
        boolean tmp = false;
        if (firstNode == null) {
            tmp = true;
        }
        return tmp;
    }

    //Method used to add to the front of the list
    public void addToFront(String _name, String _tel, String _email, String _address, String _dob) {
        _name = _name.toLowerCase();
        ListNode newFrontNode = new ListNode(_name, _tel, _email, _address, _dob);
        if (firstNode == null) {
            this.firstNode = newFrontNode;
        } else if (firstNode != null) {
            currentNode = newFrontNode;
            currentNode.setNext(this.firstNode);
            this.firstNode = currentNode;
        }
        currentNode = firstNode;
    }

    //Method used to add to the back of the list
    public void addToBack(String _name, String _tel, String _email, String _address, String _dob) {
        _name = _name.toLowerCase();
        ListNode newBackNode = new ListNode(_name, _tel, _email, _address, _dob);
        if (firstNode == null) {
            firstNode = newBackNode;
            currentNode = firstNode;
        } else if (firstNode != null) {
            if (currentNode.next == null) {
                currentNode.next = newBackNode;
                currentNode = firstNode;
            } else {
                currentNode = currentNode.next;
                this.addToBack(_name, _tel, _email, _address, _dob);
            }
        }
        currentNode = firstNode;
    }

    //Method used to generate a readable string
    public String toString() {
        String toStr = "";
        if (currentNode != null) {
            toStr += "Name: " + currentNode.getName() + "\nTelephone Number: "
                    + currentNode.getTel() + "\nEmail Address: " + currentNode.getEmail()
                    + "\nPhysical Address: " + currentNode.getAddr() + "\nDate of birth: "
                    + currentNode.getDob() + "\n\n";
            currentNode = currentNode.next;
            toStr += toString();
        }
        currentNode = firstNode;
        return toStr;

    }

    //Method that display a reversed toString 
    public String reverseToString() {
        String rvsToStr = this.reverse().toString();
        return rvsToStr;
    }

    //Method used to reverse the List
    public AddressList reverse() {
        AddressList reverseList = new AddressList();
        if (this.firstNode != null) {
            reverseList.firstNode = new ListNode(firstNode.name, firstNode.tel, firstNode.email,
                    firstNode.addr, firstNode.dob);
        }
        if (this.firstNode.next != null) {
            firstNode = firstNode.next;
            reverseList.firstNode.next = reverse().firstNode;
        } else{
            reverseList.currentNode = reverseList.firstNode;
            
        }
        return reverseList;
    }

    //Returns size of the List
    public int sizeOf() {
        int linkSize = 0;
        if (currentNode != null) {
            linkSize++;
            currentNode = currentNode.next;
            linkSize = this.sizeOf() + linkSize;
        }
        currentNode = firstNode;
        return linkSize;
    }

    //Method used to find a phone number by a name
    public String phoneNumberByName(String _name) {
        String foundNum = "No matching data";
        if (!isEmpty()) {
            _name = _name.toLowerCase();
            if (currentNode != null) {
                if (currentNode.name.equals(_name)) {
                    foundNum = ("Telephone number: " + currentNode.tel);
                } else {
                    currentNode = currentNode.next;
                    foundNum = phoneNumberByName(_name);
                }
            }
            currentNode = firstNode;
        }
        return foundNum;
    }

    //Method used to find an email by name
    public String emailByName(String _name) {
        String foundEmail = "No matching data";
        if (!isEmpty()) {
            _name = _name.toLowerCase();
            if (currentNode != null) {
                if (currentNode.name.equals(_name)) {
                    foundEmail = ("Email Address: " + currentNode.email);
                } else {
                    currentNode = currentNode.next;
                    foundEmail = emailByName(_name);
                }
            }
            currentNode = firstNode;
        }
        return foundEmail;
    }

    //Method used to find a name by phone number
    public String nameByPhoneNumber(String _tel) {
        String foundName = "No matching data";
        if (!isEmpty()) {
            if (currentNode != null) {
                if (currentNode.tel.equals(_tel)) {
                    foundName = ("Name: " + currentNode.name);
                } else {
                    currentNode = currentNode.next;
                    foundName = nameByPhoneNumber(_tel);
                }
            }
            currentNode = firstNode;
        }
        return foundName;
    }

    //Method used to find date of birth by name
    public String dobByName(String _name) {
        String foundDob = "No matching data";
        if (!isEmpty()) {
            _name = _name.toLowerCase();
            if (currentNode != null) {
                if (currentNode.name.equals(_name)) {
                    foundDob = ("Date of birth: " + currentNode.dob);
                } else {
                    currentNode = currentNode.next;
                    foundDob = dobByName(_name);
                }
            }
            currentNode = firstNode;
        }
        return foundDob;
    }

    /**
     * This nested, private class represents a node of a singly linked list.
     */
    private class ListNode {

        private String name;
        private String tel; // Telephone number
        private String email;
        private String addr; // Address
        private String dob; // Date of birth
        private ListNode next; // Pointer to the next node

        private ListNode(String name, String tel, String email, String addr, String dob) {
            this.name = name;
            this.tel = tel;
            this.email = email;
            this.addr = addr;
            this.dob = dob;
        } // end of the constructor

        //Getters and Setters
        public String getName() {
            return name;
        }

        public String getTel() {
            return tel;
        }

        public String getEmail() {
            return email;
        }

        public String getAddr() {
            return addr;
        }

        public String getDob() {
            return dob;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode link) {
            next = link;
        }
    }

}

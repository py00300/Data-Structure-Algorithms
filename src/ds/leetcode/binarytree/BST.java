package ds.leetcode.binarytree;

class Program {

  static class BST {

    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {
      if (value < this.value) {
        if (this.left == null) {
          this.left = new BST(value);
        } else {
          this.left.insert(value);
        }
      } else {
        if (this.right == null) {
          this.right = new BST(value);
        } else {
          this.right.insert(value);
        }
      }

      // Do not edit the return statement of this method.
      return this;
    }

    public boolean contains(int value) {
      if (this.value == value) {
        return true;
      }

      if (value < this.value && this.left != null) {
        return this.left.contains(value);
      }

      if (value > this.value && this.right != null) {
        return this.right.contains(value);
      }

      return false;
    }

    public BST remove(int value) {
      remove(value, null);
      // Do not edit the return statement of this method.
      return this;
    }

    public void remove(int value, BST parent) {
      if (value < this.value) {
        if (left != null) {
          this.left.remove(value, this);
        }
      } else if (value > this.value) {
        if (right != null) {
          this.right.remove(value, this);
        }
      } else {
        if (left != null && right != null) {
          this.value = right.getMinValue();
          right.remove(this.value, this);
        } else if (parent == null) {
          if (left != null) {
            this.value = left.value;
            right = left.right;
            left = left.left;
          } else if (right != null) {
            this.value = right.value;
            left = right.left;
            right = right.right;
          } else {

          }
        } else if (parent.left == this) {
          parent.left = left != null ? left : right;
        } else if (parent.right == this) {
          parent.right = left != null ? left : right;
        }

        //}
      }
    }

    public int getMinValue() {
      if (left == null) {
        return this.value;
      } else {
        return left.value;
      }
    }
  }
}


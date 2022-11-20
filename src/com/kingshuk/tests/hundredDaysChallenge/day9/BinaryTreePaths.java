package com.kingshuk.tests.hundredDaysChallenge.day9;

import com.kingshuk.tests.hundredDaysChallenge.day7.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        BinaryTreePaths binary = new BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binary.binaryTreePaths(root));
    }
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
            return list;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        addAllPaths(root, list, list2);
        StringBuilder sb = new StringBuilder();
        List<String> strings = new ArrayList<>();
        for (List<Integer> l : list2) {
            for (int i = 0; i < l.size() - 1; i++) {
                sb.append(l.get(i)).append("->");
            }
            sb.append(l.get(l.size() - 1));
            strings.add(sb.toString());
            sb.setLength(0);
        }
        return strings;
    }

    public void addAllPaths(TreeNode root,  List<Integer> list, List<List<Integer>> list2){
        if(root != null){
            list.add(root.key);
            if(root.left == null && root.right == null)
            {
                list2.add(new ArrayList<>(list));
            }else{
                addAllPaths(root.left, list, list2);
                addAllPaths(root.right, list, list2);
            }
            list.remove(list.size() - 1);
        }
    }
}

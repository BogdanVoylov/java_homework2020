package com.company;
/*Написати графічну програму, що показує файлову систему у вигляді дерева і дозволяє по ній переміщуватися, розкриваючи та закриваючи підкаталоги*/
import java.awt.*;
import java.io.File;

import javax.swing.*;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeModel;
import javax.swing.event.TreeModelListener;

public class Main extends JFrame
{
    JTree[] trees;
    Main(){
        super("Program");
        this.setSize(500,500);
        this.getContentPane().setLayout(new GridLayout(File.listRoots().length,1));
        init();
    }

    private void init(){
        File[] roots = File.listRoots();
        trees = new JTree[roots.length];
        for(int i = 0; i < roots.length; i++){
            trees[i] = new JTree(new MyTreeModel(roots[i]));
            JScrollPane jScrollPane = new JScrollPane(trees[i]);
            setPreferredSize(new Dimension(500,500));
            this.add(jScrollPane);
        }

    }
    public static void main(String[] args){
        Main main = new Main();
        main.setVisible(true);
    }

    class MyTreeModel implements TreeModel{
        private  FileWrapper root;
        MyTreeModel(File root){
            this.root = new FileWrapper(root);
        }
        @Override
        public Object getRoot() {
            return root;
        }

        @Override
        public Object getChild(Object o, int i) {
            if(o instanceof FileWrapper){
                File dir = ((FileWrapper) o).getFile();
                if(dir.isDirectory()){
                    return new FileWrapper(dir.listFiles()[i]);
                }else {
                    return null;
                }
            }else {
                return null;
            }
        }

        @Override
        public int getChildCount(Object o) {
            if(o instanceof FileWrapper){
                File dir = ((FileWrapper)o).getFile();
                if(dir.isDirectory() && dir.listFiles()!=null){
                    return  dir.listFiles().length;
                }else {
                    return 0;
                }
            }else {
                return 0;
            }
        }

        @Override
        public boolean isLeaf(Object o) {
            if(!((FileWrapper) o).getFile().isDirectory()){
                return true;
            }else {
                return false;
            }
        }

        @Override
        public void valueForPathChanged(TreePath treePath, Object o) {

        }

        @Override
        public int getIndexOfChild(Object node, Object child) {
            if( node instanceof FileWrapper && child instanceof FileWrapper){
                String[] childList = ((FileWrapper) node).getFile().list();
                File childFile =  ((FileWrapper) child).getFile();
                for(int i = 0; i < childList.length; i++){
                    if(childFile.toString().equals(childList[i])){
                        return i;
                    }
                }
            }
            return 0;
        }

        @Override
        public void addTreeModelListener(TreeModelListener treeModelListener) {

        }

        @Override
        public void removeTreeModelListener(TreeModelListener treeModelListener) {

        }
    }

    /*File Wrapper to override toString*/
    class FileWrapper{
        private File file;
        public FileWrapper(File file){
            this.file = file;
        }

        public File getFile() {
            return file;
        }

        @Override
        public String toString() {
            if(file.getParentFile()!=null){
                return file.getName();
            }else {
                return file.toString();
            }
        }
    }
}

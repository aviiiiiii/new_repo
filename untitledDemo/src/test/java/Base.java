class Base {
    public static void main(String[] args){
        System.out.println(add(6));
        String st="Hey";
        System.out.println(add(st));
    }
    public static int add(int in){
        in =in+10;
        return in;
    }
    public static String add(String st){
        st=st+"Ram";
        return st;
    }
}

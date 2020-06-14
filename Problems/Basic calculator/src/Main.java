class Problem {

    public static void main(String[] args) {
        int arg1 = Integer.parseInt(args[1]);
        int arg2 = Integer.parseInt(args[2]);
        int result;
        switch (args[0]) {
            case "+":
                result = arg1 + arg2;
                break;
            case "-":
                result = arg1 - arg2;
                break;
            case  "*":
                result = arg1 * arg2;
                break;
            default:
                System.out.println("Unknown operator");
                return;
        }
        System.out.println(result);
    }
}
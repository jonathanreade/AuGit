// TODO Add Unittest, Consider incorporating Javadoc

import com.sun.deploy.util.StringUtils;

/*
Notes: Have someone write code to give only the code within the first set of curly brackets for detectiing functions
it will then be very unlikely to have duplicates and reserved words.
 */

List<String>reserved=new ArrayList()<>;

public static class javaDetector {

    /**
     * Returns a substring of the second string from the point where
     * the strings differ until the end of the second string
     *
     * @param str1 the first string
     * @param str2 the second string to be compared with the first
     * @return String
     */
    public static String difference(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return "";
        }

        //if str1 is null indexOfDifference will return 0 and str2 will be returned
        if (str2 == null) {
            return str1;
        }
        int changeIndex = indexOfDifference(str1, str2);
        if (changeIndex == -1) {
            return "";
        }
        return str2.substring(changeIndex);
    }

    /**
     * TODO Finish this function
     *
     * @return List<String> of the reserved words for our libraries
     */
    public static List<String> getReservedLibraries(List<String> libraries) {
        return null;
    }

    /**
     * Compares two strings and returns the index of the first
     * difference between the strings
     *
     * @param str1 the first string
     * @param str2 the second string to be compared with the first
     * @return String
     */
    public static int indexOfDifference(String str1, String str2) {
        if (str1.equals(str2)) {
            return -1;
        }
        if (str1 == null || str2 == null) {
            return 0;
        }
        int i;
        for (i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param origin
     * @param current
     */
    public static void detectFunctions(String origin, String current) {
        origin = origin.toLowerCase();
        current = current.toLowerCase();
        String diff = difference(origin, current);

        // Add Vanilla Javas reserved words to our List
        // Detect Java Version for these?
        reserved.add("abstract");
        reserved.add("assert");
        reserved.add("boolean");
        reserved.add("break");
        reserved.add("byte");
        reserved.add("case");
        reserved.add("catch");
        reserved.add("char");
        reserved.add("class");
        reserved.add("const");
        reserved.add("continue");
        reserved.add("default");
        reserved.add("double");
        reserved.add("do");
        reserved.add("else");
        reserved.add("enum");
        reserved.add("extends");
        reserved.add("false");
        reserved.add("final");
        reserved.add("finally");
        reserved.add("float");
        reserved.add("for");
        reserved.add("goto");
        reserved.add("if");
        reserved.add("implements");
        reserved.add("import");
        reserved.add("instanceof");
        reserved.add("int");
        reserved.add("interface");
        reserved.add("long");
        reserved.add("native");
        reserved.add("new");
        reserved.add("null");
        reserved.add("package");
        reserved.add("private");
        reserved.add("protected");
        reserved.add("public");
        reserved.add("return");
        reserved.add("short");
        reserved.add("static");
        reserved.add("strictfp");
        reserved.add("super");
        reserved.add("switch");
        reserved.add("synchronized");
        reserved.add("this");
        reserved.add("throw");
        reserved.add("throws");
        reserved.add("transient");
        reserved.add("true");
        reserved.add("try");
        reserved.add("void");
        reserved.add("void");
        reserved.add("volatile");

        // Get reserved words for installed plugins and libraries
        // getReservedLibraries call

        List<int> checkedIndices = new ArrayList<>();
        List<FunctionDescription> functionByName = new ArrayList<>();

        int i = 0;
        for (diff:
             Char c) {
            
            // TODO (rmartin) turn this into a regex where the bracket needs to be lead by a char
            if(c == '('){
                checkedIndices.add(i);
            }
            i++;
        }

        // Here we need to go to the first word before the indices and then grab the function and add to our function
        // list iff it is not reserved
        
        for(int x: checkedIndices){
            String name = "";
            String accessMod = "";
            String retType = "";
            List<String> arguments = new ArrayList<>();
            
            int curIndex = x;
            // Grab the return valued and access modifier
            while(curIndex >0 && diff.charAt(curIndex) != ' '){
                curIndex--; 
            }
            name = diff.substring(curIndex, x);
            // curIndex -> x is the functions name
            
            // Grab return type and accessMod
            
            // Grabbing the words before each indice
            
            // Move Down and create the agruments
            
            // Create new function description and add it to array
            
            // This needs to be called on preformatted code within the outer { brackets } so that it is primarily variables and method names
        }


    }

    public static String getMessageFunctions(ArrayList<FunctionDescription> functionDescriptions) {
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < functionDescriptions.size(); i++) {
            message.append("Created function ");
            if (functionDescriptions.get(i).getRetType().equals("void")) {
                message.append("with void return type, called ");
            } else {
                message.append("with ");
                message.append(functionDescriptions.get(i).getRetType());
                message.append(" return type, called ");
            }
            message.append(functionDescriptions.get(i).getFunctionName());
            message.append(" and arguments as follows: ");
            for (int j = 0; j < functionDescriptions.get(i).getArgs().size(); j++) {
                message.append(functionDescriptions.get(i).getArgs().get(j));
                if (j + 1 == functionDescriptions.get(i).getArgs().size()) {

                } else {
                    message.append(", ");
                }
            }
            message.append(".");
        }

        System.out.println(message.toString());
        return "";
    }
    
        public static String getMessageClasses(ArrayList<ClassDescription> classDescriptions) {
        /* Generate a message for classes, use getMessageFunctions */
    }

    public static void main(String[] args) {
        ArrayList<String> argu = new ArrayList<>();
        argu.add("String name");
        argu.add("int Time");
        FunctionDescription test = new FunctionDescription("randomFunction", 2, argu, "Object");


        ArrayList<FunctionDescription> fun = new ArrayList<>();
        fun.add(test);
        getMessage(fun);

    }
}

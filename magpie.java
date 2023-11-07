public class magpie
{
    public String getGreeting()
    {
        return "Let's have a conversation together";
    }

    public String getResponse(String statement)
    {
        String response = "";
        if (statement.indexOf("no") >= 0)
        {
            response = "Why are you being so negative?";
        } else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0
                || statement.indexOf("uncle") >= 0
                || statement.indexOf("aunt") >= 0
                || statement.indexOf("cousin") >= 0)
        {
            response = "Tell me about the dynamics of your family.";
        }
        else if (findKeyword(statement, "I like", 0) >= 0)
        {
            response = iLikeStatement(statement);
        }
        else if (findKeyword(statement, "I want", 0) >=0){
            response = iWantStatement(statement);

        }

        else
        {
            int hello = findKeyword(statement, "you", 0);

            if (hello >= 0 && findKeyword(statement, "me", hello) >= 0)
            {
                response = personalStatement(statement);}
        else
        {
            response = getARandomResponse();
        }
        }
        return response;
    }

    private String iLikeStatement(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int hello = findKeyword(statement, "I like", 0);
        String restOfStatement = statement.substring(hello + 6).trim();
        return ("How much do you like " + restOfStatement + "?");
    }

    private String personalStatement(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int hello = findKeyword(statement, "You", 0);
        String restOfStatement = statement.substring( hello + 3,12).trim();
        return ("How much do I " + restOfStatement + " you?");
    }

    private String iWantStatement(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int hello = findKeyword(statement, "I want", 0);
        String restOfStatement = statement.substring(hello + 6).trim();
        return ("How much do you want " + restOfStatement + "?");}

    private int findKeyword(String statement, String goal, int startPos) {
    
         String sentence = statement.trim();
        int hello = sentence.toLowerCase().indexOf(goal.toLowerCase(), startPos);
            while(hello >= 0){

                String before = " ", after = " ";

                if (hello>0)
                {
                    before = sentence.substring(hello -1, hello).toLowerCase();
                }
                if (hello+ goal.length() < sentence.length()){
                    after = sentence.substring(hello +goal.length(), hello + goal.length() + 1).toLowerCase();
                }
                if (((before.compareTo("a") < 0)
                || (before.compareTo("z") > 0)) 
                 && ((after.compareTo("a") < 0)
                || (after.compareTo("z") > 0)))

                {
                    return hello;
                }

                hello = sentence.indexOf(goal.toLowerCase()+ hello+1);
                
            }

          return hello;
        }
   
        private int findKeyword(String statement, String goal)
        {
            return findKeyword(statement, goal, 0);
        }
    private String getARandomResponse()
    {
        
        double randomNum = Math.random();
        int theResponse = (int) (randomNum * 6);
        String response = "";

        if (theResponse == 0)
        {
            response = "That's really cool";
        }
        else if (theResponse == 1)
        {
            response = "Wow";
        }
        else if (theResponse == 2)
        {
            response = "How could that be?";
        }
        else if (theResponse == 3)
        {
            response = "That is an interesting thought";
        }
        else if (theResponse == 4)
        {
            response = "Fantastic";
        }
        else if (theResponse == 5)
        {
            response = "That's a nice thing to say";
        }
        else
        {
            response = "I'm not really sure what to say";
        }
        return response;
    }

    public static void main(String[] args)
    {
        magpie maggie = new magpie();

        System.out.println(maggie.getGreeting());
        System.out.println(">My mother and I talked last night.");
        System.out.println(
                maggie.getResponse("My mother and I talked last night."));
        System.out.println(">I said no.");
        System.out.println(maggie.getResponse("I said no!"));
        System.out.println(">The weather is nice.");
        System.out.println(maggie.getResponse("The weather is nice."));
        System.out.println(">Have you heard of my friend?");
        System.out.println(maggie.getResponse("Have you heard of my friend?"));
        
        System.out.println(maggie.findKeyword("yesterday is today's day before.", "before", 0));

        String statement = "I like robots.";
        System.out.println("Statement: " + statement);
        System.out.println("Response: " + maggie.getResponse(statement));

         statement = "I want to understand French.";
         System.out.println("Statement: " + statement);
         System.out.println("Response: " + maggie.getResponse(statement));

         statement = "You confuse me.";
         System.out.println("Statement: " + statement);
         System.out.println("Response: " + maggie.getResponse(statement));

    }

}

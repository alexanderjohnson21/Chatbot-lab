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
        else
        {
            response = getARandomResponse();
        }
        return response;
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
    }
}
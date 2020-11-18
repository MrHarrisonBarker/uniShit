public class Grade
{
    private String Subject;
    private double Score;

    public Grade(String subject, int score)
    {
        Subject = subject;
        Score = score;
    }

    public static char getLetterGrade(Double score)
    {
        if (score >= 70 && score < 100)
        {
            return 'A';
        } else if (score >= 60 && score < 100)
        {
            return 'B';
        } else if (score >= 50 && score < 100)
        {
            return 'C';
        } else if (score >= 40 && score < 100)
        {
            return 'D';
        } else if (score < 40 && score < 100)
        {
            return 'F';
        } else {
            return 'E';
        }
    }


    public String getSubject()
    {
        return Subject;
    }

    public void setSubject(String subject)
    {
        Subject = subject;
    }

    public double getScore()
    {
        return Score;
    }

    public void setScore(double score)
    {
        Score = score;
    }
}

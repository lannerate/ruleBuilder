import com.flagleader.repository.e.d;
import com.flagleader.repository.tree.RulePackage;
import java.io.File;
import java.io.PrintStream;

class c extends Thread
{
  public c(TestThread paramTestThread)
  {
  }

  public void run()
  {
    try
    {
      String str = "d:/WIFI.rpk";
      RulePackage localRulePackage = (RulePackage)new d().load(new File(str));
      System.out.println("finished!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    super.run();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     c
 * JD-Core Version:    0.6.0
 */
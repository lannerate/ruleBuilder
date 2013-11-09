public class TestThread
{
  public void a()
  {
    new c(this).start();
  }

  public static void main(String[] paramArrayOfString)
  {
    TestThread localTestThread = new TestThread();
    for (int i = 0; i < 100; i++)
      localTestThread.a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     TestThread
 * JD-Core Version:    0.6.0
 */
package com.flagleader.repository.d;

public class s extends Exception
{
  public s()
  {
  }

  public s(String paramString)
  {
    super(paramString);
  }

  public s(String paramString1, String paramString2, Throwable paramThrowable)
  {
    super("objectName=" + paramString1 + ",fieldName=" + paramString2 + ",cause=" + paramThrowable.getMessage(), paramThrowable);
  }

  public s(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }

  public s(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.s
 * JD-Core Version:    0.6.0
 */
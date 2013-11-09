package com.flagleader.manager.e;

import com.flagleader.manager.d.c;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import java.io.Writer;
import java.util.List;

public class I extends K
{
  public I(TestCaseLib paramTestCaseLib, Writer paramWriter)
  {
    super(paramTestCaseLib);
    this.b = paramWriter;
    this.g = new J(this, paramTestCaseLib);
  }

  private TestCaseLib j()
  {
    return (TestCaseLib)h();
  }

  protected void a(String paramString1, TestCase paramTestCase, String paramString2)
  {
    this.a.add(new H(paramString1, j(), paramString2));
    o().a(j() + " : " + paramString1);
  }

  public String a()
  {
    return c.b("TestCaseTread.info");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.I
 * JD-Core Version:    0.6.0
 */
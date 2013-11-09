package com.flagleader.repository.lang;

import com.flagleader.xml.XmlWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

public class f extends XmlWriter
{
  public f(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public f(Writer paramWriter)
  {
    super(paramWriter);
  }

  public f(File paramFile)
  {
    super(paramFile);
  }

  public void a(MethodInfos paramMethodInfos)
  {
    printHeader();
    String[] arrayOfString = { "displayName", paramMethodInfos.getDisplayName() };
    openMarkerLn("MethodInfos", arrayOfString);
    for (int i = 0; i < paramMethodInfos.getGlobalMethods().size(); i++)
      a((GlobalMethod)paramMethodInfos.getGlobalMethods().get(i));
    for (i = 0; i < paramMethodInfos.getTypeMethods().size(); i++)
      a((TypeMethod)paramMethodInfos.getTypeMethods().get(i));
    closeMarkerLn("MethodInfos");
    flush();
  }

  private void a(GlobalMethod paramGlobalMethod)
  {
    String[] arrayOfString = { "funcName", paramGlobalMethod.getFuncName(), "disName", paramGlobalMethod.getDisName(), "returnType", paramGlobalMethod.getReturnType(), "typeName", paramGlobalMethod.getTypeName() };
    openMarkerLn("GlobalMethod", arrayOfString);
    openMarkerLn("funcBody");
    print(toXml(paramGlobalMethod.getFuncBody()));
    closeMarkerLn("funcBody");
    closeMarkerLn("GlobalMethod");
  }

  private void a(TypeMethod paramTypeMethod)
  {
    String[] arrayOfString = { "funcName", paramTypeMethod.getFuncName(), "disName", paramTypeMethod.getDisName(), "returnType", paramTypeMethod.getReturnType(), "typeName", paramTypeMethod.getTypeName() };
    openMarkerLn("TypeMethod", arrayOfString);
    openMarkerLn("funcBody");
    print(toXml(paramTypeMethod.getFuncBody()));
    closeMarkerLn("funcBody");
    closeMarkerLn("TypeMethod");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.f
 * JD-Core Version:    0.6.0
 */
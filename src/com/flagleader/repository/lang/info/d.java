package com.flagleader.repository.lang.info;

import com.flagleader.xml.XmlWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;

public class d extends XmlWriter
{
  public d(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public d(Writer paramWriter)
  {
    super(paramWriter);
  }

  public d(File paramFile)
  {
    super(paramFile);
  }

  public void a(InfoClass paramInfoClass)
  {
    printHeader();
    String[] arrayOfString = { "displayName", paramInfoClass.getDisplayName(), "className", paramInfoClass.getClassName(), "version", paramInfoClass.getVersion(), "lasttime", paramInfoClass.getLasttime(), "versionInfo", paramInfoClass.getVersionInfo() };
    openMarkerLn("InfoClass", arrayOfString);
    Iterator localIterator = paramInfoClass.getChildrenIterator();
    while (localIterator.hasNext())
      a((InfoMember)localIterator.next());
    closeMarkerLn("InfoClass");
    flush();
  }

  private void a(InfoMember paramInfoMember)
  {
    String[] arrayOfString = { "displayName", paramInfoMember.getDisplayName(), "memberName", paramInfoMember.getMemberName(), "staticType", paramInfoMember.isStaticType(), "typeName", paramInfoMember.getTypeName() };
    openMarkerLn(paramInfoMember.getName(), arrayOfString);
    if ((paramInfoMember instanceof InfoMethod))
    {
      Iterator localIterator = paramInfoMember.getChildrenIterator();
      while (localIterator.hasNext())
        a((InfoParameter)localIterator.next());
    }
    closeMarkerLn(paramInfoMember.getName());
  }

  private void a(InfoParameter paramInfoParameter)
  {
    String[] arrayOfString = { "displayName", paramInfoParameter.getDisplayName(), "argName", paramInfoParameter.getArgName(), "typeName", paramInfoParameter.getTypeName() };
    openMarkerLn(paramInfoParameter.getName(), arrayOfString);
    closeMarkerLn(paramInfoParameter.getName());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.info.d
 * JD-Core Version:    0.6.0
 */
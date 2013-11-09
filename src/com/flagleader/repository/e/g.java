package com.flagleader.repository.e;

import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.RuleGroup;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleProject;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.xml.XmlWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

public class g extends XmlWriter
{
  private RuleProject a = null;

  public g(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public g(Writer paramWriter)
  {
    super(paramWriter);
  }

  public g(File paramFile)
  {
    super(paramFile);
  }

  public void a(RuleProject paramRuleProject)
  {
    this.a = paramRuleProject;
    printHeader();
    String[] arrayOfString = { "displayName", paramRuleProject.getDisplayName(), "uuid", paramRuleProject.getUuid(), "saveType", paramRuleProject.getSaveType(), "projver", paramRuleProject.getProjver() };
    openMarkerLn("ProjectInfo", arrayOfString);
    List localList = paramRuleProject.getChildrenList();
    for (int i = 0; i < localList.size(); i++)
    {
      Object localObject = localList.get(i);
      if ((localObject instanceof RulePackage))
      {
        a((RulePackage)localObject);
      }
      else if ((localObject instanceof Envionment))
      {
        a((Envionment)localObject);
      }
      else if ((localObject instanceof TestCaseLib))
      {
        a((TestCaseLib)localObject);
      }
      else
      {
        if (!(localObject instanceof RuleGroup))
          continue;
        a((RuleGroup)localObject);
      }
    }
    b(paramRuleProject);
    closeMarkerLn("ProjectInfo");
    flush();
  }

  private void a(RulePackage paramRulePackage)
  {
    String[] arrayOfString = { "exename", paramRulePackage.getExeRulePackageName(), "displayName", paramRulePackage.getDisplayName(), "locked", paramRulePackage.getLocked(), "ruleEditLevel", paramRulePackage.getRuleEditLevel(), "checkType", paramRulePackage.getCheckType() };
    openMarkerLn("PackageInfo", arrayOfString);
    b(paramRulePackage);
    closeMarkerLn("PackageInfo");
  }

  private void a(TestCaseLib paramTestCaseLib)
  {
    String[] arrayOfString = { "displayName", paramTestCaseLib.getDisplayName() };
    openMarkerLn("TestLibInfo", arrayOfString);
    openMarker("fileName");
    String str = paramTestCaseLib.getFilePathName();
    print(toXml(str));
    closeMarkerLn("fileName");
    closeMarkerLn("TestLibInfo");
  }

  private void a(RuleGroup paramRuleGroup)
  {
    String[] arrayOfString = { "displayName", paramRuleGroup.getDisplayName() };
    openMarkerLn("GroupInfo", arrayOfString);
    List localList = paramRuleGroup.getChildrenList();
    for (int i = 0; i < localList.size(); i++)
    {
      Object localObject = localList.get(i);
      if ((localObject instanceof RulePackage))
      {
        a((RulePackage)localObject);
      }
      else if ((localObject instanceof RuleGroup))
      {
        a((RuleGroup)localObject);
      }
      else if ((localObject instanceof TestCaseLib))
      {
        a((TestCaseLib)localObject);
      }
      else
      {
        if (!(localObject instanceof Envionment))
          continue;
        a((Envionment)localObject);
      }
    }
    closeMarkerLn("GroupInfo");
  }

  private void b(RuleProject paramRuleProject)
  {
    openMarker("document");
    print(toXml(paramRuleProject.getDocument()));
    closeMarkerLn("document");
  }

  private void b(RulePackage paramRulePackage)
  {
    openMarker("fileName");
    String str = paramRulePackage.getFilePathName();
    if (str.indexOf(this.a.getDataDir()) >= 0)
      str = str.substring(this.a.getDataDir().length() + 1);
    print(toXml(str));
    closeMarkerLn("fileName");
  }

  private void a(Envionment paramEnvionment)
  {
    openMarker("fileName");
    print(toXml(paramEnvionment.getDisplayName() + ".env"));
    closeMarkerLn("fileName");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.g
 * JD-Core Version:    0.6.0
 */
package com.flagleader.repository.f;

import com.flagleader.repository.tree.GroupInfo;
import com.flagleader.repository.tree.PackageInfo;
import com.flagleader.repository.tree.ProjectInfo;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.xml.XmlWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;

public class e extends XmlWriter
{
  public e(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public e(Writer paramWriter)
  {
    super(paramWriter);
  }

  public e(File paramFile)
  {
    super(paramFile);
  }

  public void a(ProjectInfo paramProjectInfo)
  {
    printHeader();
    String[] arrayOfString = { "displayName", paramProjectInfo.getDisplayName(), "uuid", paramProjectInfo.getUuid(), "saveType", paramProjectInfo.getSaveType(), "projver", paramProjectInfo.getProjver() };
    openMarkerLn("ProjectInfo", arrayOfString);
    List localList = paramProjectInfo.getPackageInfos();
    for (int i = 0; i < localList.size(); i++)
    {
      Object localObject = localList.get(i);
      if ((localObject instanceof PackageInfo))
      {
        a((PackageInfo)localObject);
      }
      else
      {
        if (!(localObject instanceof GroupInfo))
          continue;
        a((GroupInfo)localObject);
      }
    }
    b(paramProjectInfo);
    closeMarkerLn("ProjectInfo");
    flush();
  }

  private void a(PackageInfo paramPackageInfo)
  {
    String[] arrayOfString = { "exename", paramPackageInfo.getExename(), "displayName", paramPackageInfo.getDisplayName(), "uuid", paramPackageInfo.getUuid(), "checkType", paramPackageInfo.getCheckType() };
    openMarkerLn("PackageInfo", arrayOfString);
    b(paramPackageInfo);
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

  private void a(GroupInfo paramGroupInfo)
  {
    String[] arrayOfString = { "displayName", paramGroupInfo.getDisplayName(), "uuid", paramGroupInfo.getUuid() };
    openMarkerLn("GroupInfo", arrayOfString);
    List localList = paramGroupInfo.getPackageInfos();
    for (int i = 0; i < localList.size(); i++)
    {
      Object localObject = localList.get(i);
      if ((localObject instanceof PackageInfo))
      {
        a((PackageInfo)localObject);
      }
      else
      {
        if (!(localObject instanceof GroupInfo))
          continue;
        a((GroupInfo)localObject);
      }
    }
    closeMarkerLn("GroupInfo");
  }

  private void b(ProjectInfo paramProjectInfo)
  {
    openMarker("document");
    print(toXml(paramProjectInfo.getDocument()));
    closeMarkerLn("document");
  }

  private void b(PackageInfo paramPackageInfo)
  {
    openMarker("fileName");
    String str = paramPackageInfo.getFileName();
    print(toXml(str));
    closeMarkerLn("fileName");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.e
 * JD-Core Version:    0.6.0
 */
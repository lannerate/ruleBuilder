package com.flagleader.repository.e;

import com.flagleader.database.ConnectionFactory;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleProject;
import com.flagleader.repository.tree.RuleRepository;
import com.flagleader.util.filesystem.FileUtil;
import com.flagleader.xml.XmlWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class p extends XmlWriter
{
  private RuleRepository a;

  public p(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public p(Writer paramWriter)
  {
    super(paramWriter);
  }

  public p(File paramFile)
  {
    super(paramFile);
  }

  public void a(RuleRepository paramRuleRepository)
  {
    this.a = paramRuleRepository;
    printHeader();
    String[] arrayOfString1 = { "displayName", paramRuleRepository.getDisplayName(), "dbsPath", paramRuleRepository.getDbsPath(), "classDir", paramRuleRepository.getClassDir(), "exportPagePath", paramRuleRepository.getExportPagePath(), "exportExeRulePath", paramRuleRepository.getExportExeRulePath(), "dateFormat", paramRuleRepository.getDateFormat(), "datetimeFormat", paramRuleRepository.getDatetimeFormat(), "timeFormat", paramRuleRepository.getTimeFormat(), "rspRoot", paramRuleRepository.getRspRoot(), "driver", paramRuleRepository.getDriver(), "url", paramRuleRepository.getUrl(), "uid", paramRuleRepository.getUid(), "passwd", ConnectionFactory.encrypt(paramRuleRepository.getPasswd()), "jspRoot", paramRuleRepository.getJspRoot(), "ftpServer", paramRuleRepository.getFtpServer(), "ftpUser", paramRuleRepository.getFtpUser(), "ftpPasswd", ConnectionFactory.encrypt(paramRuleRepository.getFtpPasswd()), "ftpRscPath", paramRuleRepository.getFtpRscPath(), "ftpJspPath", paramRuleRepository.getFtpJspPath(), "ftpRulesPath", paramRuleRepository.getFtpRulesPath(), "userRuleServer", paramRuleRepository.getUserRuleServer(), "passwdRuleServer", ConnectionFactory.encrypt(paramRuleRepository.getPasswdRuleServer()), "autoFtpExe", String.valueOf(paramRuleRepository.isAutoFtpExe()), "autoFtpPage", String.valueOf(paramRuleRepository.isAutoFtpPage()), "autoFtpRules", String.valueOf(paramRuleRepository.isAutoFtpRules()), "autoCompile", String.valueOf(paramRuleRepository.isAutoCompile()), "autoExportPage", String.valueOf(paramRuleRepository.isAutoExportPage()), "autoCheck", String.valueOf(paramRuleRepository.isAutoCheck()), "showVarname", String.valueOf(paramRuleRepository.isShowVarname()), "logtrace", String.valueOf(paramRuleRepository.isLogtrace()), "ruleServiceUrl", String.valueOf(paramRuleRepository.getRuleServiceUrl()) };
    openMarkerLn(paramRuleRepository.getName(), arrayOfString1);
    Iterator localIterator1 = paramRuleRepository.getChildrenIterator();
    while (localIterator1.hasNext())
    {
      Object localObject1 = localIterator1.next();
      if ((localObject1 instanceof RuleProject))
      {
        a((RuleProject)localObject1);
      }
      else
      {
        if (!(localObject1 instanceof RulePackage))
          continue;
        a((RulePackage)localObject1);
      }
    }
    int i = 0;
    Iterator localIterator2 = paramRuleRepository.getClosedProject().keySet().iterator();
    while (localIterator2.hasNext())
    {
      Object localObject2 = localIterator2.next();
      String[] arrayOfString2 = { "key", localObject2.toString(), "property", paramRuleRepository.getClosedProject().get(localObject2).toString() };
      openCloseMarkerLn("advancedProperty", arrayOfString2);
      if (i++ >= 10)
        break;
    }
    closeMarkerLn(paramRuleRepository.getName());
    flush();
  }

  private void a(RuleProject paramRuleProject)
  {
    String str = paramRuleProject.getFilePath();
    if ((this.a.getRepFile() != null) && (str.indexOf(this.a.getRepFile().getParent()) >= 0))
      str = str.substring(this.a.getRepFile().getParent().length() + 1);
    if ((!this.a.isDefaultFile()) && (FileUtil.getCurrentDir().length() > 0) && (str.indexOf(FileUtil.getCurrentDir() + File.separator) == 0))
      str = str.substring(FileUtil.getCurrentDir().length() + File.separator.length());
    String[] arrayOfString = { "displayName", paramRuleProject.getDisplayName(), "uuid", paramRuleProject.getUuid(), "filePath", str, "opened", paramRuleProject.isOpened() ? "true" : "false" };
    openMarkerLn(paramRuleProject.getName(), arrayOfString);
    closeMarkerLn(paramRuleProject.getName());
  }

  private void a(RulePackage paramRulePackage)
  {
    if (paramRulePackage.isDbRules())
      return;
    String str = paramRulePackage.getFilePathName();
    String[] arrayOfString = { "displayName", paramRulePackage.getDisplayName(), "uuid", paramRulePackage.getUuid(), "filePath", str };
    openMarkerLn(paramRulePackage.getName(), arrayOfString);
    closeMarkerLn(paramRulePackage.getName());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.p
 * JD-Core Version:    0.6.0
 */
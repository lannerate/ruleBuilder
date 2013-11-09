package com.flagleader.repository.tree;

import com.flagleader.database.ConnectionFactory;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.a;
import com.flagleader.repository.e.p;
import com.flagleader.repository.h;
import com.flagleader.repository.n;
import com.flagleader.util.StringUtil;
import com.flagleader.util.exception.UnsupportOperationException;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.SystemUtils;

public class RuleRepository extends AbstractTreeNode
  implements IRuleRepository
{
  private transient File repFile = null;
  public static final String DEFAULTEXT = SystemUtils.USER_HOME + File.separator + ".visualrules" + File.separator + "default.rep";
  private String dbsPath = "";
  private String classDir = "";
  private String exportPagePath = "Tomcat/webapps/ROOT";
  private String exportExeRulePath = "Tomcat/webapps/ROOT/WEB-INF/classes";
  private String dateFormat = "yyyy-MM-dd";
  private String datetimeFormat = "yyyy-MM-dd HH:mm:ss";
  private String timeFormat = "HH:mm:ss";
  private String rspRoot = "rsp";
  private String driver = "com.mysql.jdbc.Driver";
  private String url = "jdbc:mysql://localhost/rules";
  private String uid = "rules";
  private String passwd = "rules";
  private String jspRoot = "http://localhost:8880/";
  private String ftpServer = "127.0.0.1";
  private String ftpUser = "anonymous";
  private String ftpPasswd = "anonymous";
  private String ftpRscPath = "/WEB-INF/classes/";
  private String ftpJspPath = "/";
  private String ftpRulesPath = "/WEB-INF/rules/";
  private String userRuleServer = "";
  private String passwdRuleServer = "";
  private boolean autoFtpExe = false;
  private boolean autoFtpPage = false;
  private boolean autoFtpRules = false;
  private boolean autoCompile = true;
  private boolean autoExportPage = true;
  private boolean autoCheck = false;
  private boolean logtrace = false;
  private boolean showVarname = true;
  private String ruleServiceUrl = "";
  private transient boolean needSave = false;
  private transient boolean forceClose = false;
  private transient h logger = null;
  private transient a bomClassLoader;
  private an ruleServer = null;
  private transient LinkedHashMap closedProject = new LinkedHashMap();

  public RuleRepository(RuleRepository paramRuleRepository)
  {
    super(paramRuleRepository);
  }

  public RuleRepository()
  {
  }

  public RuleRepository(File paramFile)
  {
    this.repFile = paramFile;
  }

  public Iterator getProjects()
  {
    return getChildrenIterator();
  }

  public boolean isDefaultFile()
  {
    return this.repFile.getPath().equals(new File(DEFAULTEXT).getPath());
  }

  public Iterator getRulePackages()
  {
    return getAcceptElements(new az(this));
  }

  public void addRulePackage(RulePackage paramRulePackage)
  {
    addChildElement(paramRulePackage);
  }

  public void addRuleProject(IRuleProject paramIRuleProject)
  {
    addChildElement(paramIRuleProject);
    setNeedSave(true);
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IRuleProject)) || ((paramIElement instanceof RulePackage));
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    throw new UnsupportOperationException();
  }

  public String getName()
  {
    return "RuleRepository";
  }

  public IRuleProject getProject()
  {
    return null;
  }

  public IElement deepClone()
  {
    return new RuleRepository(this);
  }

  protected boolean b()
  {
    return super.b();
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    if ((paramITreeNode instanceof IRuleProject))
      return true;
    return super.acceptNode(paramITreeNode);
  }

  public boolean canUpdate()
  {
    return true;
  }

  public ITreeNode createChildNode(String paramString)
  {
    throw new UnsupportOperationException();
  }

  public Iterator getAcceptNodes()
  {
    if (b())
      return super.getAcceptNodes();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(RuleProject.nodeInfo);
    return localArrayList.iterator();
  }

  public void selfSave()
  {
    if ((getRepFile() != null) && (!this.forceClose))
    {
      p localp = new p(getRepFile());
      localp.a(this);
      localp.close();
      this.needSave = false;
    }
  }

  public void save()
  {
    selfSave();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof RuleProject))
      {
        RuleProject localRuleProject = (RuleProject)localObject;
        localRuleProject.save();
      }
      else
      {
        if (!(localObject instanceof RulePackage))
          continue;
        ((RulePackage)localObject).save();
      }
    }
  }

  public IElement getParent()
  {
    return null;
  }

  public void autoSave()
  {
    if (this.needSave)
      selfSave();
    List localList = getChildrenList();
    for (int i = 0; i < localList.size(); i++)
    {
      Object localObject = localList.get(i);
      if (!(localObject instanceof RuleProject))
        continue;
      RuleProject localRuleProject = (RuleProject)localObject;
      localRuleProject.autoSave();
    }
  }

  public List getAutoSavedPack()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RuleProject))
        continue;
      RuleProject localRuleProject = (RuleProject)localObject;
      localArrayList.addAll(localRuleProject.getAutoSavedPack());
    }
    return localArrayList;
  }

  public boolean recoverAutoSavePack(List paramList)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof RuleProject)) && (((RuleProject)localObject).exitsPackage(paramList.get(0).toString()) != null))
        return ((RuleProject)localObject).recoverAutoSavePack(paramList);
    }
    return false;
  }

  public void backup(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 3) || (!new File(paramList.get(2).toString()).exists()))
      return;
    File localFile = new File(paramList.get(2).toString());
    try
    {
      FileUtil.copy(localFile, new File(StringUtil.replace(".autosave", ".backup", localFile.getPath())), true);
    }
    catch (Exception localException)
    {
    }
  }

  public void clearBackup(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 3) || (!new File(paramList.get(2).toString()).exists()))
      return;
    File localFile1 = new File(paramList.get(2).toString());
    File localFile2 = new File(StringUtil.replace(".autosave", ".backup", localFile1.getPath()));
    if (localFile2.exists())
      localFile2.delete();
  }

  public void clearAutoSave()
  {
    try
    {
      if (this.needSave)
        autoSave();
    }
    catch (Exception localException)
    {
    }
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RuleProject))
        continue;
      RuleProject localRuleProject = (RuleProject)localObject;
      localRuleProject.clearAutoSave();
    }
  }

  public RuleProject exitsProject(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof IRuleProject)) && (((RuleProject)localObject).getUuid().equals(paramString)))
        return (RuleProject)localObject;
    }
    return null;
  }

  public IRulePackage exitsPackage(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof IRulePackage)) && (((IRulePackage)localObject).getExeRulePackageName().equalsIgnoreCase(paramString)))
        return (IRulePackage)localObject;
    }
    return null;
  }

  public boolean open()
  {
    List localList = a();
    Object localObject;
    for (int i = 0; i < localList.size(); i++)
    {
      localObject = localList.get(i);
      if ((!(localObject instanceof RuleProject)) || (!((RuleProject)localObject).isOpened()))
        continue;
      File localFile = new File(((RuleProject)localObject).getFilePath());
      if ((!localFile.exists()) && (getRepFile() != null))
        localFile = new File(getRepFile().getParent(), ((RuleProject)localObject).getFilePath());
      if (!localFile.exists())
        localFile = new File(FileUtil.getCurrentDir(), ((RuleProject)localObject).getFilePath());
      if (localFile.exists())
      {
        ((RuleProject)localObject).setFilePath(localFile.getAbsolutePath());
        ((RuleProject)localObject).open();
      }
      else
      {
        ((RuleProject)localObject).setOpened(false);
      }
    }
    for (i = localList.size() - 1; i >= 0; i--)
    {
      localObject = localList.get(i);
      if ((!(localObject instanceof RuleProject)) || (((RuleProject)localObject).isOpened()))
        continue;
      ((RuleProject)localObject).dispose();
    }
    return true;
  }

  public boolean isModified()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof ITreeNode)) && (((ITreeNode)localObject).isModified()))
        return true;
    }
    return false;
  }

  public boolean isVisible()
  {
    return true;
  }

  public boolean isLocked()
  {
    return false;
  }

  public File getRepFile()
  {
    return this.repFile;
  }

  public void setRepFile(File paramFile)
  {
    this.repFile = paramFile;
  }

  public void setNeedSave(boolean paramBoolean)
  {
    try
    {
      if (paramBoolean)
        selfSave();
    }
    catch (Exception localException)
    {
    }
  }

  public void setModified(boolean paramBoolean)
  {
    if (paramBoolean)
      try
      {
        selfSave();
      }
      catch (Exception localException)
      {
      }
  }

  public List getClosedNode()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.closedProject.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      String str = this.closedProject.get(localObject).toString();
      RuleProject localRuleProject = new RuleProject(str);
      localRuleProject.setFilePath(localObject.toString());
      localRuleProject.setOpened(false);
      localArrayList.add(localRuleProject);
    }
    return localArrayList;
  }

  public boolean isAutoCompile()
  {
    return this.autoCompile;
  }

  public void setAutoCompile(boolean paramBoolean)
  {
    this.autoCompile = paramBoolean;
  }

  public boolean isAutoExportPage()
  {
    return this.autoExportPage;
  }

  public void setAutoExportPage(boolean paramBoolean)
  {
    this.autoExportPage = paramBoolean;
  }

  public boolean isAutoFtpExe()
  {
    return this.autoFtpExe;
  }

  public void setAutoFtpExe(boolean paramBoolean)
  {
    this.autoFtpExe = paramBoolean;
  }

  public boolean isAutoFtpPage()
  {
    return this.autoFtpPage;
  }

  public void setAutoFtpPage(boolean paramBoolean)
  {
    this.autoFtpPage = paramBoolean;
  }

  public boolean isAutoFtpRules()
  {
    return this.autoFtpRules;
  }

  public void setAutoFtpRules(boolean paramBoolean)
  {
    this.autoFtpRules = paramBoolean;
  }

  public String getClassDir()
  {
    return this.classDir;
  }

  public void setClassDir(String paramString)
  {
    this.classDir = paramString;
  }

  public String getDateFormat()
  {
    return this.dateFormat;
  }

  public void setDateFormat(String paramString)
  {
    this.dateFormat = paramString;
  }

  public String getDatetimeFormat()
  {
    return this.datetimeFormat;
  }

  public void setDatetimeFormat(String paramString)
  {
    this.datetimeFormat = paramString;
  }

  public String getDbsPath()
  {
    return this.dbsPath;
  }

  public void setDbsPath(String paramString)
  {
    this.dbsPath = paramString;
  }

  public String getDriver()
  {
    return this.driver;
  }

  public void setDriver(String paramString)
  {
    this.driver = paramString;
  }

  public String getExportExeRulePath()
  {
    return this.exportExeRulePath;
  }

  public void setExportExeRulePath(String paramString)
  {
    this.exportExeRulePath = paramString;
  }

  public String getExportPagePath()
  {
    return this.exportPagePath;
  }

  public void setExportPagePath(String paramString)
  {
    this.exportPagePath = paramString;
  }

  public String getFtpJspPath()
  {
    return this.ftpJspPath;
  }

  public void setFtpJspPath(String paramString)
  {
    this.ftpJspPath = paramString;
  }

  public String getFtpPasswd()
  {
    return this.ftpPasswd;
  }

  public void setFtpPasswd(String paramString)
  {
    this.ftpPasswd = ConnectionFactory.decrypt(paramString);
  }

  public String getFtpRscPath()
  {
    return this.ftpRscPath;
  }

  public void setFtpRscPath(String paramString)
  {
    this.ftpRscPath = paramString;
  }

  public String getFtpRulesPath()
  {
    return this.ftpRulesPath;
  }

  public void setFtpRulesPath(String paramString)
  {
    this.ftpRulesPath = paramString;
  }

  public String getFtpServer()
  {
    return this.ftpServer;
  }

  public void setFtpServer(String paramString)
  {
    this.ftpServer = paramString;
  }

  public String getFtpUser()
  {
    return this.ftpUser;
  }

  public void setFtpUser(String paramString)
  {
    this.ftpUser = paramString;
  }

  public String getJspRoot()
  {
    return this.jspRoot;
  }

  public void setJspRoot(String paramString)
  {
    this.jspRoot = paramString;
  }

  public String getPasswd()
  {
    return this.passwd;
  }

  public void setPasswd(String paramString)
  {
    this.passwd = ConnectionFactory.decrypt(paramString);
  }

  public String getPasswdRuleServer()
  {
    return this.passwdRuleServer;
  }

  public void setPasswdRuleServer(String paramString)
  {
    this.passwdRuleServer = ConnectionFactory.decrypt(paramString);
  }

  public String getTimeFormat()
  {
    return this.timeFormat;
  }

  public void setTimeFormat(String paramString)
  {
    this.timeFormat = paramString;
  }

  public String getUid()
  {
    return this.uid;
  }

  public void setUid(String paramString)
  {
    this.uid = paramString;
  }

  public String getUrl()
  {
    return this.url;
  }

  public void setUrl(String paramString)
  {
    this.url = paramString;
  }

  public String getUserRuleServer()
  {
    return this.userRuleServer;
  }

  public String getLocalUser()
  {
    if ((getUserRuleServer() == null) || (getUserRuleServer().length() == 0) || (getUserRuleServer().equals("admin")))
      return getLocalip();
    return getUserRuleServer();
  }

  public void setUserRuleServer(String paramString)
  {
    this.userRuleServer = paramString;
  }

  public boolean isNeedSave()
  {
    return this.needSave;
  }

  public static String getLocalip()
  {
    String str = "";
    try
    {
      if ((InetAddress.getLocalHost() != null) && (InetAddress.getLocalHost().getAddress() != null))
        for (int i = 0; i < InetAddress.getLocalHost().getAddress().length; i++)
        {
          if (i > 0)
            str = str + ".";
          str = str + unSigned(InetAddress.getLocalHost().getAddress()[i]);
        }
    }
    catch (UnknownHostException localUnknownHostException)
    {
      return SystemUtils.USER_NAME;
    }
    return str;
  }

  private static int unSigned(byte paramByte)
  {
    if (paramByte < 0)
      return 256 + paramByte;
    return paramByte;
  }

  public boolean isAutoCheck()
  {
    return this.autoCheck;
  }

  public void setAutoCheck(boolean paramBoolean)
  {
    this.autoCheck = paramBoolean;
  }

  public boolean isLogtrace()
  {
    return this.logtrace;
  }

  public void setLogtrace(boolean paramBoolean)
  {
    this.logtrace = paramBoolean;
  }

  public boolean isShowVarname()
  {
    return this.showVarname;
  }

  public void setShowVarname(boolean paramBoolean)
  {
    this.showVarname = paramBoolean;
  }

  public h getLogger()
  {
    if (this.logger == null)
      this.logger = n.g("ruleengine");
    return this.logger;
  }

  public String getRuleServiceUrl()
  {
    return this.ruleServiceUrl;
  }

  public void setRuleServiceUrl(String paramString)
  {
    this.ruleServiceUrl = paramString;
  }

  public a getBomClassLoader()
  {
    if (this.bomClassLoader == null)
      this.bomClassLoader = new a();
    this.bomClassLoader.a(this.classDir.split(";"));
    this.bomClassLoader.a(a.d());
    return this.bomClassLoader;
  }

  public an getRuleServer()
  {
    return this.ruleServer;
  }

  public void setRuleServer(an paraman)
  {
    this.ruleServer = paraman;
  }

  public IRulePackage exitsDBPackage(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IRuleProject))
        continue;
      RulePackage localRulePackage = ((IRuleProject)localObject).exitsPackage(paramString);
      if (localRulePackage != null)
        return localRulePackage;
    }
    return null;
  }

  public RuleDBProject getDBProject(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof RuleDBProject)) && (((RuleDBProject)localObject).getDisplayName().equalsIgnoreCase(paramString)))
        return (RuleDBProject)localObject;
    }
    return null;
  }

  public RuleProject getProject(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof RuleProject)) && (((RuleProject)localObject).getDisplayName().equalsIgnoreCase(paramString)))
        return (RuleProject)localObject;
    }
    return null;
  }

  public void addDBProject(String paramString)
  {
    RuleDBProject localRuleDBProject = getDBProject(paramString);
    if (localRuleDBProject == null)
    {
      localRuleDBProject = new RuleDBProject(paramString);
      addChildElement(localRuleDBProject);
    }
  }

  public void addDBPackage(IRulePackage paramIRulePackage, String paramString1, String paramString2)
  {
    RuleDBProject localRuleDBProject = getDBProject(paramString1);
    if (localRuleDBProject == null)
    {
      localRuleDBProject = new RuleDBProject(paramString1);
      addChildElement(localRuleDBProject);
    }
    localRuleDBProject.addGroupPackage(paramIRulePackage, paramString2);
  }

  public void addProjPackage(IRulePackage paramIRulePackage, String paramString1, String paramString2)
  {
    RuleProject localRuleProject = getProject(paramString1);
    if (localRuleProject == null)
    {
      localRuleProject = new RuleProject(paramString1);
      localRuleProject.setDisplayName(paramString1);
      File localFile = new File(FileUtil.getCurrentDir(), "dbproj/" + paramString1);
      try
      {
        if (!localFile.exists())
          localFile.mkdirs();
      }
      catch (Exception localException)
      {
      }
      localRuleProject.setFilePath(new File(localFile, "default.prj").getPath());
      localRuleProject.createDirectory();
      addChildElement(localRuleProject);
    }
    localRuleProject.addGroupPackage(paramIRulePackage, paramString2);
    localRuleProject.setNeedSave(true);
  }

  public int getUserType()
  {
    if (this.ruleServer != null)
      return this.ruleServer.y();
    return 3;
  }

  public String getRspRoot()
  {
    return this.rspRoot;
  }

  public void setRspRoot(String paramString)
  {
    this.rspRoot = paramString;
  }

  public boolean isForceClose()
  {
    return this.forceClose;
  }

  public void setForceClose(boolean paramBoolean)
  {
    this.forceClose = paramBoolean;
  }

  public void removeChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof RuleProject))
      this.closedProject.put(((RuleProject)paramIElement).getFilePath(), ((RuleProject)paramIElement).getDisplayName());
    super.removeChildElement(paramIElement);
  }

  public LinkedHashMap getClosedProject()
  {
    return this.closedProject;
  }

  public void removeClosed(String paramString)
  {
    this.closedProject.remove(paramString);
  }

  public void addAdvanceProperty(AdvancedProperty paramAdvancedProperty)
  {
    this.closedProject.put(paramAdvancedProperty.getKey(), paramAdvancedProperty.getProperty());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RuleRepository
 * JD-Core Version:    0.6.0
 */
package com.flagleader.repository.tree;

import com.flagleader.engine.Property;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.u;
import com.flagleader.repository.d.x;
import com.flagleader.repository.e.d;
import com.flagleader.repository.e.h;
import com.flagleader.repository.e.m;
import com.flagleader.repository.e.t;
import com.flagleader.repository.export.AjaxPage;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.n;
import com.flagleader.repository.rlm.AbstractBOToken;
import com.flagleader.repository.rlm.action.AssignToken;
import com.flagleader.repository.rlm.action.PackCatchActionToken;
import com.flagleader.repository.rlm.condition.ConditionToken;
import com.flagleader.repository.rlm.condition.RuleLogConditionToken;
import com.flagleader.repository.rlm.lang.IMultiActionToken;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.SystemUtils;

public class RulePackage extends AbstractPackageElement
  implements IElement, IDebugNode, IRulePackage, IRuleSet
{
  public static final String FILEEXT = ".rpk";
  public static final String NAME = "RulePackage";
  public static final String DISPLAYNAME = getLocalString("RulePackage.text");
  public static final NodeInfo nodeInfo = new NodeInfo("RulePackage", DISPLAYNAME, DISPLAYNAME);
  private transient String dirPath = "";
  private String fileName = "";
  private transient boolean locked = false;
  private String exportDir = "";
  private transient String[] classPaths = new String[0];
  private String packageName = "";
  private String version = "1.0";
  private String projver = "";
  private String mainVersion = "";
  private long createTime = System.currentTimeMillis();
  private int checkType = 0;
  public static final int NONCHECK = 0;
  public static final int CHECKIN = 1;
  public static final int CHECKOUT = 2;
  public static final int LOCKCHECKOUT = 3;
  private boolean visible = true;
  private transient boolean dbRules = false;
  private transient int rulesid = 0;
  private transient String compilePath = "";
  private transient String filePathName = "";
  private transient boolean plugin = false;
  private long startTime = 0L;
  private long endTime = 0L;
  private transient long autoSaveTime = 0L;
  private transient int edittype = 0;
  public static int DEVELOPER = 0;
  public static int EDITER = 1;
  public static int READER = 2;
  private int stringignore = NOTIGNORE;
  public static int NOTIGNORE = 0;
  public static int IGNORE = 1;
  private int stringinit = 1;
  public static int STRINGNULL = 0;
  public static int STRINGEMPTY = 1;
  private int datenulltype = 0;
  private transient long checkedtime = 0L;
  private transient int editError = 1;
  private List errorList = null;
  public static final int NEEDCHECK = 0;
  public static final int NOERROR = 1;
  public static final int HASERROR = 2;
  private int logType = 1;
  public static final int LOG = 0;
  public static final int NOTLOG = 1;
  private int fileVersion = 6;
  public static final int SUPPORTVERSION = 6;
  private int logTimes = 0;
  public static final int NOTLOGTIMES = 0;
  public static final int LOGTIMES = 1;
  private int vmlFlowType = 3;
  public static final int SHOWALLRULE = 0;
  public static final int SHOWNAMEONLY = 1;
  public static final int SHOWDETAILONLY = 2;
  public static final int SHOWNAMEDETAIL = 3;
  private String templateType = "";
  private transient long serverTime = 0L;
  private int dblog = 0;
  public static final int LOGINDBNOT = 0;
  public static final int LOGINDB = 1;
  private transient int ruletypeid = 0;
  private int webrole = 0;
  public static final int WEBALLVISIT = 0;
  public static final int WEBUSERVISIT = 1;
  public static final int WEBNOVISIT = 2;
  private int checktype = 0;
  public static final int CHECKSUBNONE = 0;
  public static final int CHECKSUBWHOLE = 1;
  public static final int CHECKSUBCONFLICT = 2;
  private transient RulePackage comparePackage = null;
  private int ruleEditLevel = 0;
  public static final int EDITALL = 0;
  public static final int EDITSIMPLE = 1;
  public static final int EDITTREEFLOW = 2;
  public static final int EDITPOOLFLOW = 3;
  public static final int EDITRELATEDECISION = 4;
  public static final int EDITMULTIDECISION = 5;
  public static final int EDITDECISION = 6;
  private long getAllRuleElementTime = 0L;
  private ArrayList allRules = null;

  public RulePackage()
  {
  }

  public RulePackage(RulePackage paramRulePackage)
  {
    super(paramRulePackage);
    this.packageName = paramRulePackage.packageName;
    this.startTime = paramRulePackage.startTime;
    this.endTime = paramRulePackage.endTime;
    this.logType = paramRulePackage.logType;
    this.datenulltype = paramRulePackage.datenulltype;
    this.stringinit = paramRulePackage.stringinit;
    this.stringignore = paramRulePackage.stringignore;
    this.fileVersion = paramRulePackage.fileVersion;
    this.logTimes = paramRulePackage.logTimes;
    this.vmlFlowType = paramRulePackage.vmlFlowType;
    this.templateType = paramRulePackage.templateType;
  }

  public RulePackage(String paramString)
  {
    setDisplayName(paramString);
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return ((paramITreeNode instanceof IRuleTree)) || ((paramITreeNode instanceof TestCaseLib)) || ((paramITreeNode instanceof IPage));
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return (paramString.equals("RuleSet")) || (paramString.equals("RuleSetFlow")) || (paramString.equals("RuleTreeFlow")) || (paramString.equals("Rule")) || (paramString.equals("TestCaseLib")) || (paramString.equals("RulePoolFlow")) || (paramString.equals("ExportModel")) || (paramString.equals("DecisionRule")) || (paramString.equals("DecisionMultiRule")) || (paramString.equals("DecisionRelateRule")) || (paramString.equals("RuleMirror")) || (paramString.equals("AjaxPage")) || (paramString.equals("ExpressionRule"));
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitRulePackage(this);
  }

  public void addChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof IRuleTree))
    {
      super.addChildElement(paramIElement, getRuleAndSetCount());
    }
    else if ((paramIElement instanceof TestCaseLib))
    {
      super.addChildElement(paramIElement, getChildrenCount());
    }
    else if ((paramIElement instanceof IPage))
    {
      super.addChildElement(paramIElement, getChildrenCount() - getTestCount());
    }
    else if ((paramIElement instanceof RuleLogConditionToken))
    {
      int i = 0;
      List localList2 = a();
      for (int k = 0; k < localList2.size(); k++)
      {
        if (!(localList2.get(k) instanceof RuleLogConditionToken))
          continue;
        i = 1;
        break;
      }
      if (i == 0)
        super.addChildElement(paramIElement, getChildrenCount());
    }
    else if ((paramIElement instanceof Envionment))
    {
      List localList1 = a();
      for (int j = 0; j < localList1.size(); j++)
      {
        if (!(localList1.get(j) instanceof Envionment))
          continue;
        ((Envionment)localList1.get(j)).dispose();
      }
      super.addChildElement(paramIElement, getChildrenCount());
    }
    else
    {
      super.addChildElement(paramIElement, getChildrenCount());
    }
  }

  public void appendChild(IElement paramIElement)
  {
    a().add(paramIElement);
  }

  public void autoSave()
  {
    if (getProject() != null)
    {
      getProject().save(this, true);
    }
    else if (getAutoSaveTime() < getMaxModifyTime())
    {
      File localFile = new File(SystemUtils.JAVA_IO_TMPDIR + File.separator + getPackageDirString());
      localFile.mkdirs();
      com.flagleader.repository.e.e locale = new com.flagleader.repository.e.e(new File(SystemUtils.JAVA_IO_TMPDIR + File.separator + getPackageDirString(), getFileName() + ".rpk.autosave"));
      locale.a(this);
      locale.close();
      setAutoSaveTime(System.currentTimeMillis());
    }
  }

  public List getAutoSavedPack()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (isLocked())
      return localArrayList1;
    File localFile = new File(SystemUtils.JAVA_IO_TMPDIR + File.separator + getPackageDirString(), getFileName() + ".rpk.autosave");
    if (!localFile.exists())
      localFile = new File(SystemUtils.JAVA_IO_TMPDIR + File.separator + getPackageDirString(), getFileName() + ".rpk.backup");
    if (localFile.exists())
    {
      int i = SystemUtils.JAVA_IO_TMPDIR.length() + File.separator.length();
      String str = localFile.getPath().substring(i, localFile.getPath().lastIndexOf(".rpk")).replace(File.separatorChar, '.');
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(str);
      localArrayList2.add(String.valueOf(localFile.lastModified()));
      localArrayList2.add(localFile.getPath());
      localArrayList1.add(localArrayList2);
    }
    return localArrayList1;
  }

  public boolean recoverAutoSavePack(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 3) || (!new File(paramList.get(2).toString()).exists()))
      return false;
    try
    {
      RulePackage localRulePackage = (RulePackage)new d().load(new File(paramList.get(2).toString()));
      disposeAllChildren();
      setModifyTime(localRulePackage.getModifyTime());
      setDisplayName(localRulePackage.getDisplayName());
      setPackageName(localRulePackage.packageName);
      setFileName(localRulePackage.fileName);
      setDocument(localRulePackage.getDocument());
      setUuid(localRulePackage.getUuid());
      setStringignore(localRulePackage.stringignore);
      setStringinit(localRulePackage.stringinit);
      setDatenulltype(localRulePackage.datenulltype);
      setDirPath(localRulePackage.dirPath);
      setFilePathName(localRulePackage.filePathName);
      this.startTime = localRulePackage.startTime;
      this.endTime = localRulePackage.endTime;
      this.logType = localRulePackage.logType;
      this.datenulltype = localRulePackage.datenulltype;
      this.stringinit = localRulePackage.stringinit;
      this.stringignore = localRulePackage.stringignore;
      this.fileVersion = localRulePackage.fileVersion;
      this.logTimes = localRulePackage.logTimes;
      this.vmlFlowType = localRulePackage.vmlFlowType;
      this.templateType = localRulePackage.templateType;
      for (int i = 0; i < localRulePackage.getChildrenCount(); i++)
        addChildElement((IRuleSet)localRulePackage.a().get(i));
      clearBackup(paramList);
      setNeedSave(true);
      updateTree();
      return true;
    }
    catch (Exception localException)
    {
      n.a().b(paramList.get(2).toString() + " is error!", localException);
    }
    return false;
  }

  public String compile(boolean paramBoolean)
  {
    com.flagleader.repository.lang.c localc = getLanguageWriter();
    String str = localc.b(this);
    return new com.flagleader.repository.a.c().a(getCompilePath(), getClassPath(), getExeRulePackageName(), "", getRuleClassName(), str, paramBoolean);
  }

  public String getText()
  {
    return new m().b(this);
  }

  public boolean comparePack(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 3) || (!new File(paramList.get(2).toString()).exists()))
      return false;
    try
    {
      RulePackage localRulePackage = (RulePackage)new d().load(new File(paramList.get(2).toString()));
      setComparePackage(localRulePackage);
      updateTree();
      updateViewer();
      return true;
    }
    catch (Exception localException)
    {
      n.a().b(paramList.get(2).toString() + " is error!", localException);
    }
    return false;
  }

  public boolean comparePack(String paramString)
  {
    try
    {
      RulePackage localRulePackage = (RulePackage)new d().load(paramString);
      setComparePackage(localRulePackage);
      updateTree();
      updateViewer();
      return true;
    }
    catch (Exception localException)
    {
      n.a().b("error when read rule package!", localException);
    }
    return false;
  }

  public void replaceRulePackage(RulePackage paramRulePackage)
  {
    disposeAllChildren();
    for (int i = 0; i < paramRulePackage.getChildrenCount(); i++)
      addChildElement((IRuleSet)paramRulePackage.a().get(i));
    setDisplayName(paramRulePackage.getDisplayName());
    setPackageName(paramRulePackage.getPackageName());
    setFileName(paramRulePackage.getFileName());
    setMainVersion(paramRulePackage.getMainVersion());
    setModifyTime(System.currentTimeMillis());
    setDocument(paramRulePackage.getDocument());
    setStringignore(paramRulePackage.getStringignore());
    setStringinit(paramRulePackage.getStringinit());
    setDatenulltype(paramRulePackage.getDatenulltype());
    setModified(true);
  }

  public void clearAutoSave()
  {
    if (getProject() != null)
    {
      getProject().clearAutoSave(this);
    }
    else
    {
      File localFile = new File(SystemUtils.JAVA_IO_TMPDIR + File.separator + getPackageDirString(), getFileName() + ".rpk.autosave");
      if (localFile.exists())
        localFile.delete();
    }
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

  public boolean canUpdate()
  {
    return true;
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof IRuleTree)) || ((paramIElement instanceof TestCaseLib)) || ((paramIElement instanceof Envionment)) || ((paramIElement instanceof IPage)) || ((paramIElement instanceof RuleLogConditionToken)) || ((paramIElement instanceof PackageHistory)) || ((paramIElement instanceof PackCatchActionToken)) || ((paramIElement instanceof CheckRuleInfo));
  }

  public String getClassName()
  {
    return getRuleClassName();
  }

  public String getClassPath()
  {
    String str = getExportDirPath();
    for (int i = 0; i < this.classPaths.length; i++)
    {
      if (this.classPaths[i] == null)
        continue;
      str = str + ";" + this.classPaths[i];
    }
    String[] arrayOfString = getEnvionment().getClassDirs();
    for (int j = 0; j < arrayOfString.length; j++)
    {
      if (arrayOfString[j] == null)
        continue;
      str = str + ";" + arrayOfString[j];
    }
    return str;
  }

  public ITreeNode createChildNode(String paramString)
  {
    Object localObject;
    if (paramString.equalsIgnoreCase("RuleSet"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new RuleSet(getChildDefaultName(RuleSet.DISPLAYNAME));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RuleSetFlow"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new RuleSetFlow(getChildDefaultName(RuleSetFlow.DISPLAYNAME));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RuleTreeFlow"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new RuleTreeFlow(getChildDefaultName(RuleTreeFlow.DISPLAYNAME));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RulePoolFlow"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new RulePoolFlow(getChildDefaultName(RulePoolFlow.DISPLAYNAME));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("Rule"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new Rule(getChildDefaultName(Rule.DISPLAYNAME));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("TestCaseLib"))
    {
      localObject = new TestCaseLib(getChildDefaultName(TestCaseLib.DISPLAYNAME));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("ExportModel"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new ExportModel(getChildDefaultName("test.rsp"));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("AjaxPage"))
    {
      localObject = null;
      if (localObject == null)
        localObject = new AjaxPage(getChildDefaultName("json.jsp"));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionRule"))
    {
      localObject = new DecisionRule(getChildDefaultName(DecisionRule.DISPLAYNAME));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionMultiRule"))
    {
      localObject = new DecisionMultiRule(getChildDefaultName(DecisionMultiRule.DISPLAYNAME));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("ExpressionRule"))
    {
      localObject = new ExpressionRule(getChildDefaultName(ExpressionRule.DISPLAYNAME));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("DecisionRelateRule"))
    {
      localObject = new DecisionRelateRule(getChildDefaultName(DecisionRelateRule.DISPLAYNAME));
      addChildElement((IRuleSet)localObject);
      return localObject;
    }
    return (ITreeNode)super.createChildNode(paramString);
  }

  public IElement deepClone()
  {
    return new RulePackage(this);
  }

  public Iterator getAcceptNodes()
  {
    if (b())
      return super.getAcceptNodes();
    ArrayList localArrayList = new ArrayList(8);
    localArrayList.add(RuleSet.nodeInfo);
    localArrayList.add(RuleSetFlow.nodeInfo);
    localArrayList.add(RuleTreeFlow.nodeInfo);
    localArrayList.add(RulePoolFlow.nodeInfo);
    localArrayList.add(Rule.nodeInfo);
    localArrayList.add(DecisionRule.nodeInfo);
    localArrayList.add(DecisionMultiRule.nodeInfo);
    localArrayList.add(ExpressionRule.nodeInfo);
    localArrayList.add(DecisionRelateRule.nodeInfo);
    localArrayList.add(TestCaseLib.nodeInfo);
    localArrayList.add(ExportModel.nodeInfo);
    localArrayList.add(AjaxPage.nodeInfo);
    return localArrayList.iterator();
  }

  public void changeElementType(IBusinessObject paramIBusinessObject)
  {
    String str = paramIBusinessObject.getValueType();
    List localList = getAllElementSelect(paramIBusinessObject);
    for (int i = 0; i < localList.size(); i++)
    {
      IElement localIElement = (IRuleSet)localList.get(i);
      if ((localIElement instanceof AbstractBOToken))
      {
        if ((localIElement.getParent() instanceof AssignToken))
          ((AssignToken)localIElement.getParent()).changeValueType(str);
        if ((localIElement.getParent() instanceof ConditionToken))
          ((ConditionToken)localIElement.getParent()).changeValueType(str);
        (localIElement.getParent() instanceof IValueContainerToken);
        ((AbstractBOToken)localIElement).setValueType(str);
        ((AbstractBOToken)localIElement).getRoot().setModified(true);
      }
      else if ((localIElement instanceof DecisionElementValue))
      {
        ((DecisionElementValue)localIElement).getAssignValue().changeValueType(str);
      }
      else
      {
        if (!(localIElement instanceof DecisionValue))
          continue;
        ((DecisionValue)localIElement).getAssignValue().changeValueType(str);
      }
    }
  }

  public void changeParamType(IFunctionObject paramIFunctionObject)
  {
    List localList1 = getAllElementSelect(paramIFunctionObject);
    for (int i = 0; i < localList1.size(); i++)
    {
      IElement localIElement = (IRuleSet)localList1.get(i);
      if (!(localIElement instanceof MemberToken))
        continue;
      List localList2 = ((MemberToken)localIElement).getValueTokens();
      for (int j = 0; j < localList2.size(); j++)
      {
        ValueToken localValueToken = (ValueToken)localList2.get(j);
        if ((localValueToken == null) || (((MemberToken)localIElement).getParamType(localValueToken.getArgName()) == null))
          continue;
        localValueToken.changeValueType(((MemberToken)localIElement).getParamType(localValueToken.getArgName()).K());
        localValueToken.getRoot().setModified(true);
      }
    }
  }

  public List getAllRuleElement()
  {
    if ((this.getAllRuleElementTime == getMaxModifyTime()) && (this.allRules != null))
      return this.allRules;
    this.allRules = new ArrayList();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      Object localObject = localList.get(i);
      if ((localObject instanceof IRule))
        this.allRules.add(localObject);
      if ((localObject instanceof IRuleSet))
        this.allRules.addAll(((IRuleSet)localObject).getAllRuleElement());
      if (!(localObject instanceof Envionment))
        continue;
      this.allRules.addAll(((Envionment)localObject).getAllRuleElement());
    }
    this.getAllRuleElementTime = getMaxModifyTime();
    return this.allRules;
  }

  public String getDirPath()
  {
    if (getProject() != null)
      return getProject().getDataDir();
    return this.dirPath;
  }

  public Envionment getEnvionment()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof Envionment))
        return (Envionment)localList.get(i);
    Envionment localEnvionment = Envionment.getEmptyEnvionment();
    addChildElement(localEnvionment, getChildrenCount());
    return localEnvionment;
  }

  public PackageHistory getHistory()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof PackageHistory))
        return (PackageHistory)localList.get(i);
    return null;
  }

  public String getFileName()
  {
    if (this.fileName.length() > 0)
      return this.fileName;
    return getDisplayName();
  }

  public String getRelativeFilePath()
  {
    String str = "";
    if (this.packageName.length() > 0)
      str = str + (str.length() != 0 ? File.separator : new StringBuilder().append(this.packageName.replace('.', File.separatorChar)).toString());
    return str + (str.length() != 0 ? File.separator : "") + getFileName() + ".rpk";
  }

  public String getFilePathName()
  {
    if (this.filePathName.length() > 0)
      return this.filePathName;
    String str = getDirPath();
    if (this.packageName.length() > 0)
    {
      str = str + (str.length() != 0 ? File.separator : "");
      str = str + this.packageName.replace('.', File.separatorChar);
    }
    return str + (str.length() != 0 ? File.separator : "") + getFileName() + ".rpk";
  }

  public String getPackageDirString()
  {
    if (this.packageName.length() > 0)
      return this.packageName.replace('.', File.separatorChar);
    return "";
  }

  public int getMaxPos()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleProject)))
      return ((IRuleProject)getParent()).getRuleGroupCount() + ((IRuleProject)getParent()).getRulePackageCount();
    if ((getParent() != null) && ((getParent() instanceof RuleGroup)))
      return ((RuleGroup)getParent()).getRuleGroupCount() + ((RuleGroup)getParent()).getRulePackageCount();
    return 0;
  }

  public int getMinPos()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleProject)))
      return ((IRuleProject)getParent()).getRuleGroupCount();
    if ((getParent() != null) && ((getParent() instanceof RuleGroup)))
      return ((RuleGroup)getParent()).getRuleGroupCount();
    return 0;
  }

  public String getName()
  {
    return "RulePackage";
  }

  public String getPackageName()
  {
    return this.packageName;
  }

  public boolean isValidPackage()
  {
    if (this.packageName.length() > 0)
      return Character.isJavaIdentifierStart(this.packageName.charAt(0));
    return false;
  }

  public int getPos()
  {
    if ((getParent() != null) && (getParent().getElementPos(this) >= 0))
      return getParent().getElementPos(this);
    return 0;
  }

  public String getRuleClassName()
  {
    if ((getFileName().length() > 0) && (StringUtil.isJavaLetter(getFileName())) && (StringUtil.isJavaLetter(this.mainVersion)))
      return "R" + getFileName() + this.mainVersion + StringUtil.replace(".", "_", this.version);
    if (StringUtil.isJavaLetter(this.mainVersion))
      return "R" + Integer.toHexString(getFileName().hashCode()) + this.mainVersion + StringUtil.replace(".", "_", this.version);
    return "R" + Integer.toHexString(getFileName().hashCode()) + Integer.toHexString(this.mainVersion.hashCode()) + StringUtil.replace(".", "_", this.version);
  }

  public String getNoVersionClassName()
  {
    if ((getFileName().length() > 0) && (StringUtil.isJavaLetter(getFileName())))
      return "R" + getFileName();
    return "R" + getUuid().substring(4);
  }

  public Iterator getRuleAndSets()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof IRuleTree))
        continue;
      localArrayList.add(localList.get(i));
    }
    return localArrayList.iterator();
  }

  public int getRuleTableCount()
  {
    int i = 0;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IRuleTree))
        continue;
      i += ((IRuleTree)localObject).getRuleTableCount();
    }
    return i;
  }

  public int getMaxDeepin()
  {
    int i = 0;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof IRuleSet))
      {
        int j = ((IRuleSet)localObject).getMaxDeepin();
        if (j <= i)
          continue;
        i = j;
      }
      else
      {
        if ((!(localObject instanceof IRule)) || (i != 0))
          continue;
        i = 1;
      }
    }
    return i + 1;
  }

  public void addHistory()
  {
    List localList1 = a();
    for (int i = 0; i < localList1.size(); i++)
    {
      if (!(localList1.get(i) instanceof PackageHistory))
        continue;
      ((PackageHistory)localList1.get(i)).disposeAndUpdate();
    }
    PackageHistory localPackageHistory = new PackageHistory();
    List localList2 = getAllRuleElement();
    for (int j = 0; j < localList2.size(); j++)
    {
      RuleHistory localRuleHistory = new RuleHistory();
      localRuleHistory.setUuid(((IRule)localList2.get(j)).getUuid());
      localRuleHistory.setDisplayName(((IRule)localList2.get(j)).toString());
      IRule localIRule = (IRule)((IRule)localList2.get(j)).deepClone();
      localIRule.setModified(false);
      localIRule.setModifyTime(localIRule.getModifyTime());
      localRuleHistory.addChildElement(localIRule);
      localPackageHistory.addChildElement(localRuleHistory);
    }
    addChildElement(localPackageHistory);
  }

  public boolean addVariableDebug(IVariableObject paramIVariableObject)
  {
    boolean bool = false;
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof IDebugNode))
        continue;
      bool = ((IDebugNode)localList.get(i)).addVariableDebug(paramIVariableObject);
    }
    return bool;
  }

  public boolean clearDebug()
  {
    boolean bool = false;
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof IDebugNode))
        continue;
      bool = ((IDebugNode)localList.get(i)).clearDebug();
    }
    return bool;
  }

  public List getRulesList()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof IRuleTree))
        continue;
      localArrayList.add(localList.get(i));
    }
    return localArrayList;
  }

  public Iterator getExportModels()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof ExportModel))
        continue;
      localArrayList.add(localList.get(i));
    }
    return localArrayList.iterator();
  }

  public boolean needRecompile()
  {
    File localFile = new File(getCompilePath(), getFileName() + ".rsc");
    if ((localFile.exists()) && (localFile.lastModified() > getMaxModifyTime()))
      return false;
    if (!localFile.exists())
      return true;
    Iterator localIterator = getAcceptElements(new at(this));
    while (localIterator.hasNext())
      if (((ITreeNode)localIterator.next()).isModified())
        return true;
    return false;
  }

  public String getExeRulePackageName()
  {
    if (this.packageName.length() > 0)
      return this.packageName + "." + getFileName();
    return getFileName();
  }

  public String getIncludeVersionName()
  {
    return getExeRulePackageName() + this.mainVersion + StringUtil.replace(".", "_", this.version);
  }

  public String getSavedText()
  {
    return com.flagleader.repository.e.e.b(this);
  }

  public void setExeRulePackageName(String paramString)
  {
    RulePackage localRulePackage = (RulePackage)deepClone();
    disposeAllChildren();
    setUuid(null);
    for (int i = 0; i < localRulePackage.getChildrenCount(); i++)
      addChildElement((IRuleSet)localRulePackage.a().get(i));
    paramString = paramString.trim();
    if (paramString.lastIndexOf(".") != -1)
    {
      setPackageName(paramString.substring(0, paramString.lastIndexOf(".")));
      setFileName(paramString.substring(paramString.lastIndexOf(".") + 1));
    }
    else
    {
      setPackageName("");
      setFileName(paramString);
    }
    String str = getDirPath();
    if (this.packageName.length() > 0)
    {
      str = str + (str.length() != 0 ? File.separator : "");
      str = str + this.packageName.replace('.', File.separatorChar);
    }
    this.filePathName = (str + (str.length() != 0 ? File.separator : "") + getFileName() + ".rpk");
    setModified(true);
    updateTree();
  }

  public String getVisitExeName()
  {
    return getExeRulePackageName();
  }

  public void changeDisplayName(String paramString)
  {
    setDisplayName(paramString);
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  public boolean isEmpty()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      Object localObject = localList.get(i);
      if (((localObject instanceof IRuleContainer)) && (!((IRuleContainer)localObject).isEmpty()))
        return false;
      if (((localObject instanceof IRuleTree)) && (!((IRuleTree)localObject).isEmpty()))
        return false;
    }
    return true;
  }

  public boolean isLocked()
  {
    if ((getProject() != null) && (getProject().isLocked()))
      return true;
    if (getRepository() != null)
    {
      if (getRepository().getUserType() == 1)
        return true;
    }
    else if (this.edittype == 2)
      return true;
    IRuleProject localIRuleProject = getProject();
    if ((localIRuleProject != null) && (localIRuleProject.isMultiFileSave()))
    {
      File localFile = new File(getSrcPath() + "." + getName());
      if ((localFile.exists()) && (!localFile.canWrite()))
        return true;
    }
    return this.locked;
  }

  public boolean getLocked()
  {
    return this.locked;
  }

  protected boolean b()
  {
    return super.b();
  }

  public void save()
  {
    if (getProject() != null)
      getProject().save(this, false);
    else if ((!isDbRules()) || (new File(getFilePathName()).exists()))
      selfSave();
  }

  public void selfSave()
  {
    IRuleProject localIRuleProject = getProject();
    new File(getFilePathName()).getParentFile().mkdirs();
    com.flagleader.repository.e.e.a(this, new File(getFilePathName()));
    if ((localIRuleProject != null) && (localIRuleProject.isMultiFileSave()))
    {
      File localFile = new File(getSrcPath() + "." + getName());
      localFile.getParentFile().mkdirs();
      if ((this.d) || (!localFile.exists()) || (localFile.lastModified() != this.f))
      {
        t.a(this, localFile);
        localFile.setLastModified(this.f);
      }
      Iterator localIterator = getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject == null) || (!(localObject instanceof ITreeNode)))
          continue;
        ((ITreeNode)localObject).save();
      }
    }
    setModified(false);
    clearAutoSave();
  }

  public String getSrcPath()
  {
    IRuleProject localIRuleProject = getProject();
    if (localIRuleProject != null)
      return localIRuleProject.getSrcDir() + File.separator + getDisplayName();
    return getDirPath() + File.separator + getDisplayName();
  }

  public void disposeAndUpdate()
  {
    if (getProject() != null)
      getProject().setModified(true);
    if ((getParent() != null) && ((getParent() instanceof RuleRepository)))
    {
      ((RuleRepository)getParent()).setNeedSave(true);
      ((RuleRepository)getParent()).setModified(true);
    }
    super.disposeAndUpdate();
  }

  public void saveHistoryRules()
  {
    List localList = getAllRuleElement();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof Rule))
        continue;
      Rule localRule = (Rule)localList.get(i);
      if (getProject() == null)
        continue;
      x.a().a(getProject().getBakDir());
      x.a().a(localRule);
    }
  }

  public List getHistoryPack()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (getProject() != null)
    {
      File localFile = new File(getProject().getBakDir() + File.separator + getPackageDirString());
      if (localFile.isDirectory())
      {
        File[] arrayOfFile = localFile.listFiles();
        for (int i = 0; i < arrayOfFile.length; i++)
        {
          if ((!arrayOfFile[i].exists()) || (!arrayOfFile[i].isFile()) || (arrayOfFile[i].getName().indexOf(getFileName() + ".rpk~") < 0) || (arrayOfFile[i].getPath().indexOf(getProject().getBakDir()) < 0))
            continue;
          int j = arrayOfFile[i].getPath().indexOf(getProject().getBakDir()) + getProject().getBakDir().length() + 1;
          String str = arrayOfFile[i].getPath().substring(j, arrayOfFile[i].getPath().lastIndexOf(".rpk~")).replace(File.separatorChar, '.');
          ArrayList localArrayList2 = new ArrayList(3);
          localArrayList2.add(str);
          localArrayList2.add(String.valueOf(arrayOfFile[i].lastModified()));
          localArrayList2.add(arrayOfFile[i].getPath());
          localArrayList1.add(localArrayList2);
        }
      }
    }
    return localArrayList1;
  }

  public void setDirPath(String paramString)
  {
    this.dirPath = paramString;
  }

  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }

  public void setFilePathName(String paramString)
  {
    this.filePathName = paramString;
    if ((paramString == null) || (paramString.length() == 0))
    {
      this.dirPath = "";
      return;
    }
    String str = "";
    int i = paramString.lastIndexOf(getFileName() + ".rpk") - 1;
    if (i < 0)
    {
      n.a().a(format("packagefilepath.error", new String[] { getExeRulePackageName(), paramString }));
      i = paramString.lastIndexOf(File.separatorChar);
    }
    if (i > 0)
      str = paramString.substring(0, i);
    if (this.packageName.length() > 0)
    {
      i = paramString.lastIndexOf(this.packageName.replace('.', File.separatorChar) + File.separatorChar);
      if (i > 0)
      {
        str = paramString.substring(0, i - 1);
      }
      else
      {
        n.a().a(format("packagefilepath.error", new String[] { getExeRulePackageName(), paramString }));
        this.dirPath = "";
      }
    }
    this.dirPath = str;
  }

  public void setLocked(boolean paramBoolean)
  {
    this.locked = paramBoolean;
    if ((getProject() != null) && (getProject().isMultiFileSave()))
    {
      File localFile = new File(getSrcPath() + "." + getName());
      if (localFile.exists())
        if (paramBoolean)
        {
          localFile.setReadOnly();
        }
        else
        {
          localFile.delete();
          try
          {
            selfsave(false);
          }
          catch (Exception localException)
          {
          }
        }
    }
  }

  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }

  public void setPos(int paramInt)
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleGroup)))
    {
      if (paramInt < 0)
        return;
      if (getParent().getElementPos(this) == paramInt)
        return;
      getParent().removeChildElement(this);
      getParent().addChildElement(this, paramInt);
      if (getProject() != null)
        getProject().setNeedSave(true);
    }
  }

  public int getRuleAndSetCount()
  {
    int i = 0;
    List localList = a();
    for (int j = 0; j < localList.size(); j++)
    {
      if (!(localList.get(j) instanceof IRuleTree))
        continue;
      i++;
    }
    return i;
  }

  public int getTestCount()
  {
    int i = 0;
    List localList = a();
    for (int j = 0; j < localList.size(); j++)
    {
      if (!(localList.get(j) instanceof TestCaseLib))
        continue;
      i++;
    }
    return i;
  }

  public String toString()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleGroup)))
      return getParent().toString() + "-" + getDisplayName();
    return getDisplayName();
  }

  public String getLastModifyTime()
  {
    if (this.f > 0L)
      return Property.getInstance().formatDatetime(new Date(this.f));
    return "";
  }

  public void setLastModifyTime(String paramString)
  {
    try
    {
      this.f = new SimpleDateFormat(u.c()).parse(paramString).getTime();
    }
    catch (ParseException localParseException)
    {
      this.f = 0L;
    }
  }

  public String getExportDir()
  {
    return this.exportDir;
  }

  public String getExportDirPath()
  {
    String str = this.exportDir;
    if (new File(FileUtil.getCurrentDir(), str).exists())
      return new File(FileUtil.getCurrentDir(), str).getAbsolutePath();
    return str;
  }

  public void setExportDir(String paramString)
  {
    this.exportDir = paramString;
  }

  public String[] getClassPaths()
  {
    if ((this.classPaths != null) && (this.classPaths.length > 0))
      return this.classPaths;
    if ((getParent() != null) && ((getParent() instanceof RuleRepository)))
      return new String[] { ((RuleRepository)getParent()).getClassDir() };
    if ((getParent() != null) && ((getParent() instanceof RuleProject)) && ((((RuleProject)getParent()).getParent() instanceof RuleRepository)))
      return new String[] { ((RuleRepository)((RuleProject)getParent()).getParent()).getClassDir() };
    if ((getParent() != null) && ((getParent() instanceof RuleDBProject)) && ((getParent().getParent() instanceof RuleRepository)))
      return new String[] { ((RuleRepository)((RuleDBProject)getParent()).getParent()).getClassDir() };
    if ((getParent() != null) && ((getParent() instanceof RuleGroup)) && (((RuleGroup)getParent()).getRepository() != null))
      return new String[] { ((RuleRepository)((RuleGroup)getParent()).getRepository()).getClassDir() };
    return new String[0];
  }

  public void setClassPaths(String[] paramArrayOfString)
  {
    this.classPaths = paramArrayOfString;
  }

  public String getCompilePath()
  {
    if ((this.compilePath.length() == 0) && (getRepository() != null))
    {
      String str = getRepository().getExportExeRulePath();
      if (new File(FileUtil.getCurrentDir(), str).exists())
        return new File(FileUtil.getCurrentDir(), str).getAbsolutePath();
      return str;
    }
    return this.compilePath;
  }

  public IRuleRepository getRepository()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleRepository)))
      return (IRuleRepository)getParent();
    if ((getParent() != null) && ((getParent() instanceof IRuleProject)))
      return ((IRuleProject)getParent()).getRepository();
    if ((getParent() != null) && ((getParent() instanceof RuleGroup)))
      return ((RuleGroup)getParent()).getRepository();
    return new RuleRepository();
  }

  public void setCompilePath(String paramString)
  {
    this.compilePath = paramString;
  }

  public boolean isVisible()
  {
    return this.visible;
  }

  public void setVisible(boolean paramBoolean)
  {
    this.visible = paramBoolean;
  }

  public boolean isDbRules()
  {
    return this.dbRules;
  }

  public void setDbRules(boolean paramBoolean)
  {
    this.dbRules = paramBoolean;
  }

  public int getRulesid()
  {
    return this.rulesid;
  }

  public void setRulesid(int paramInt)
  {
    this.rulesid = paramInt;
  }

  public boolean isPlugin()
  {
    return this.plugin;
  }

  public void setPlugin(boolean paramBoolean)
  {
    this.plugin = paramBoolean;
  }

  public long getEndTime()
  {
    return this.endTime;
  }

  public void setEndTime(long paramLong)
  {
    this.endTime = paramLong;
  }

  public long getStartTime()
  {
    return this.startTime;
  }

  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }

  public long getModifyTime()
  {
    return this.f;
  }

  public void setModifyTime(long paramLong)
  {
    this.f = paramLong;
  }

  public void setNeedSave(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public long getCreateTime()
  {
    return this.createTime;
  }

  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }

  public long getAutoSaveTime()
  {
    return this.autoSaveTime;
  }

  public void setAutoSaveTime(long paramLong)
  {
    this.autoSaveTime = paramLong;
  }

  public int getCheckType()
  {
    return this.checkType;
  }

  public void setCheckType(int paramInt)
  {
    this.checkType = paramInt;
  }

  public boolean isCheckIn()
  {
    return this.checkType == 1;
  }

  public boolean isCheckOut()
  {
    return (this.checkType == 2) || (this.checkType == 3);
  }

  public boolean isLockCheckOut()
  {
    return this.checkType == 3;
  }

  public int getLockType()
  {
    if (this.locked)
      return 1;
    return 0;
  }

  public void setLockType(int paramInt)
  {
    this.locked = (paramInt == 1);
  }

  public List getClosedNode()
  {
    return new ArrayList(0);
  }

  public String getAllVersion()
  {
    if ((this.mainVersion == null) || (this.mainVersion.length() == 0))
      return getVersion();
    return this.mainVersion + getVersion();
  }

  public String getVersion()
  {
    if ((this.version == null) || (this.version.length() == 0))
      return "1.0";
    return this.version;
  }

  public void setVersion(String paramString)
  {
    this.version = paramString;
  }

  public int getEdittype()
  {
    return this.edittype;
  }

  public void setEdittype(int paramInt)
  {
    this.edittype = paramInt;
  }

  public boolean isDeveloper()
  {
    if (getRepository() != null)
      return getRepository().getUserType() == 3;
    return this.edittype == DEVELOPER;
  }

  public boolean canVmlShow()
  {
    List localList = getAllRuleElement();
    for (int i = 0; i < localList.size(); i++)
      if (((IRule)localList.get(i)).canVmlShow())
        return true;
    return super.canVmlShow();
  }

  public RulePackage getComparePackage()
  {
    return this.comparePackage;
  }

  public void setComparePackage(RulePackage paramRulePackage)
  {
    this.comparePackage = paramRulePackage;
    if (paramRulePackage != null)
      paramRulePackage.setLocked(true);
  }

  public IPackageElement findTreeNode(String paramString)
  {
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof IPackageElement))
        continue;
      IPackageElement localIPackageElement1 = (IPackageElement)a().get(i);
      if (localIPackageElement1.getUuid().equals(paramString))
        return localIPackageElement1;
      IPackageElement localIPackageElement2 = localIPackageElement1.findTreeNode(paramString);
      if (localIPackageElement2 != null)
        return localIPackageElement2;
    }
    return null;
  }

  public IPackageElement findRuleHistory(String paramString1, String paramString2)
  {
    if (this.comparePackage != null)
      return this.comparePackage.findTreeNode(paramString1);
    PackageHistory localPackageHistory = getHistory();
    if (localPackageHistory != null)
      return localPackageHistory.findRuleHistory(paramString1, paramString2);
    return null;
  }

  public boolean canFindHistory()
  {
    if (this.comparePackage != null)
      return true;
    PackageHistory localPackageHistory = getHistory();
    return localPackageHistory != null;
  }

  public void setError(List paramList)
  {
    this.errorList = paramList;
    int i = 0;
    this.checkedtime = getMaxModifyTime();
    for (int j = 0; j < this.errorList.size(); j++)
    {
      if (((com.flagleader.repository.e)this.errorList.get(j)).d() >= 2)
        continue;
      i = 1;
      break;
    }
    if (i != 0)
      this.editError = 2;
    else
      this.editError = 1;
  }

  public boolean needCheck()
  {
    return (this.checkedtime != getMaxModifyTime()) || (this.editError == 0);
  }

  public boolean hasError()
  {
    if (this.checkedtime == getMaxModifyTime())
      return this.editError == 2;
    this.errorList = new h().c(this);
    this.checkedtime = getMaxModifyTime();
    for (int i = 0; i < this.errorList.size(); i++)
    {
      if (((com.flagleader.repository.e)this.errorList.get(i)).d() >= 2)
        continue;
      this.editError = 2;
      break;
    }
    return this.editError == 2;
  }

  public int getStringignore()
  {
    return this.stringignore;
  }

  public void setStringignore(int paramInt)
  {
    this.stringignore = paramInt;
  }

  public boolean needLog()
  {
    return true;
  }

  public boolean noChildLog()
  {
    return false;
  }

  private IMultiActionToken a(int paramInt)
  {
    List localList = a();
    int i = 0;
    for (int j = 0; j < localList.size(); j++)
      if (((localList.get(j) instanceof IMultiActionToken)) && (((IMultiActionToken)localList.get(j)).getType() == paramInt))
        return (IMultiActionToken)localList.get(j);
    return null;
  }

  public PackCatchActionToken getCatchActions()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof PackCatchActionToken))
        return (PackCatchActionToken)localList.get(i);
    PackCatchActionToken localPackCatchActionToken = new PackCatchActionToken(4);
    super.addChildElement(localPackCatchActionToken);
    return localPackCatchActionToken;
  }

  public RuleLogConditionToken getLogCondition()
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof RuleLogConditionToken))
        return (RuleLogConditionToken)localList.get(i);
    RuleLogConditionToken localRuleLogConditionToken = new RuleLogConditionToken(3);
    addChildElement(localRuleLogConditionToken);
    return localRuleLogConditionToken;
  }

  public int getStringinit()
  {
    return this.stringinit;
  }

  public void setStringinit(int paramInt)
  {
    this.stringinit = paramInt;
  }

  public boolean isIgniorString()
  {
    return this.stringignore == IGNORE;
  }

  public IRulePackage getMainPackage()
  {
    return this;
  }

  public String getCurrentUser()
  {
    if (getRepository() != null)
      return getRepository().getLocalUser();
    return RuleRepository.getLocalip();
  }

  public List getErrorList()
  {
    hasError();
    return this.errorList;
  }

  public Iterator getRulePackages()
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(this);
    return localArrayList.iterator();
  }

  public String getMainVersion()
  {
    return this.mainVersion;
  }

  public void setMainVersion(String paramString)
  {
    this.mainVersion = paramString;
  }

  public int getDatenulltype()
  {
    return this.datenulltype;
  }

  public void setDatenulltype(int paramInt)
  {
    this.datenulltype = paramInt;
  }

  public boolean canDeleteFile()
  {
    if (!new File(getFilePathName()).exists())
      return false;
    IRuleProject localIRuleProject = getProject();
    return (localIRuleProject == null) || (!localIRuleProject.exitsSamePackage(getExeRulePackageName()));
  }

  public int getLogType()
  {
    return this.logType;
  }

  public void setLogType(int paramInt)
  {
    this.logType = paramInt;
  }

  public int getFileVersion()
  {
    return this.fileVersion;
  }

  public void setFileVersion(int paramInt)
  {
    this.fileVersion = paramInt;
  }

  public int getLogTimes()
  {
    return this.logTimes;
  }

  public void setLogTimes(int paramInt)
  {
    this.logTimes = paramInt;
  }

  public int getVmlFlowType()
  {
    return this.vmlFlowType;
  }

  public void setVmlFlowType(int paramInt)
  {
    this.vmlFlowType = paramInt;
  }

  public String getTemplateType()
  {
    return this.templateType;
  }

  public void setTemplateType(String paramString)
  {
    this.templateType = paramString;
  }

  public String getProjver()
  {
    return this.projver;
  }

  public void setProjver(String paramString)
  {
    this.projver = paramString;
  }

  public long getServerTime()
  {
    if (this.serverTime == 0L)
      return getMaxModifyTime();
    return this.serverTime;
  }

  public void setServerTime(long paramLong)
  {
    this.serverTime = paramLong;
  }

  public void setCheckedtime(long paramLong)
  {
    this.checkedtime = paramLong;
  }

  public boolean isChangedshint()
  {
    if ((this.comparePackage != null) && (this.comparePackage.getModifyTime() != getModifyTime()))
      return true;
    return this.e;
  }

  public int getDblog()
  {
    return this.dblog;
  }

  public void setDblog(int paramInt)
  {
    this.dblog = paramInt;
  }

  public int getRuletypeid()
  {
    return this.ruletypeid;
  }

  public void setRuletypeid(int paramInt)
  {
    this.ruletypeid = paramInt;
  }

  public String getIdAndVersion()
  {
    return getUuid() + getVersion();
  }

  public boolean isNeedSave()
  {
    if (isModified())
      return true;
    if ((getProject() != null) && (!getProject().isMultiFileSave()))
      return !new File(getFilePathName()).exists();
    return false;
  }

  public IRulePackage getCompilePackage()
  {
    return this;
  }

  public boolean paste(IElement paramIElement)
  {
    if ((paramIElement instanceof ElementContainer))
    {
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        IElement localIElement = (IRuleSet)localIterator.next();
        if ((localIElement instanceof IRuleTree))
          continue;
        getEnvionment().paste(localIElement);
      }
    }
    return super.paste(paramIElement);
  }

  public int getWebrole()
  {
    return this.webrole;
  }

  public void setWebrole(int paramInt)
  {
    this.webrole = paramInt;
  }

  public void setSupportVisit(boolean paramBoolean)
  {
  }

  public int getChecktype()
  {
    return this.checktype;
  }

  public void setChecktype(int paramInt)
  {
    this.checktype = paramInt;
  }

  public CheckRuleInfo getCheckRuleInfo()
  {
    List localList = a();
    int i = 0;
    for (int j = 0; j < localList.size(); j++)
      if ((localList.get(j) instanceof CheckRuleInfo))
        return (CheckRuleInfo)localList.get(j);
    CheckRuleInfo localCheckRuleInfo = new CheckRuleInfo();
    localCheckRuleInfo.initTestInfo();
    addChildElement(localCheckRuleInfo);
    return localCheckRuleInfo;
  }

  public boolean needCheckSubRule()
  {
    return this.checktype > 0;
  }

  public int getRuleEditLevel()
  {
    return this.ruleEditLevel;
  }

  public void setRuleEditLevel(int paramInt)
  {
    this.ruleEditLevel = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RulePackage
 * JD-Core Version:    0.6.0
 */
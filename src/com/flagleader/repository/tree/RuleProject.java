package com.flagleader.repository.tree;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.c;
import com.flagleader.repository.d.u;
import com.flagleader.repository.d.y;
import com.flagleader.repository.d.z;
import com.flagleader.repository.e.d;
import com.flagleader.repository.e.e;
import com.flagleader.repository.e.f;
import com.flagleader.repository.e.g;
import com.flagleader.repository.e.s;
import com.flagleader.repository.m;
import com.flagleader.repository.n;
import com.flagleader.util.StringUtil;
import com.flagleader.util.exception.UnsupportOperationException;
import com.flagleader.util.filesystem.FileExistsException;
import com.flagleader.util.filesystem.FileUtil;
import com.flagleader.xml.XmlParserException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RuleProject extends AbstractTreeNode
  implements IRuleGroup, IRuleProject
{
  public static final String NAME = "RuleProject";
  public static final String DISPLAYNAME = getLocalString("RuleProject.text");
  public static final NodeInfo nodeInfo = new NodeInfo("RuleProject", DISPLAYNAME, DISPLAYNAME);
  private String filePath = ".";
  private transient boolean opened = true;
  private transient Map writableRuleSet = new HashMap();
  private transient boolean locked = false;
  public static final String DATADIR = "data";
  public static final String TESTDIR = "test";
  public static final String BAKDIR = "bak";
  public static final String RMKDIR = "rmk";
  public static final String EXPDIR = "exp";
  public static final String CLASSDIR = "classes";
  public static final String LIBDIR = "lib";
  public static final String SRCDIR = "src";
  public static final String FILENAME = "default.prj";
  public static final String FILEEXT = ".prj";
  private transient long autoSaveTime = 0L;
  private int saveType = 0;
  public static final int SIMPLEFILE = 0;
  public static final int MULTIFILE = 1;
  private String projver = "";

  public RuleProject()
  {
  }

  public RuleProject(String paramString)
  {
    setDisplayName(DISPLAYNAME);
  }

  public RuleProject(RuleProject paramRuleProject)
  {
    super(paramRuleProject);
  }

  public Envionment getEnvionment()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof Envionment))
        return (Envionment)localObject;
    }
    return null;
  }

  public Iterator getRulePackages()
  {
    return getAcceptElements(new au(this));
  }

  public void updateTableDisplayNames()
  {
    Iterator localIterator = getRulePackages();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RulePackage))
        continue;
      ((RulePackage)localObject).getEnvionment().updateTableDisplayNames();
    }
  }

  public int getRuleGroupCount()
  {
    int i = 0;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RuleGroup))
        continue;
      i++;
    }
    return i;
  }

  public int getRulePackageCount()
  {
    int i = 0;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RulePackage))
        continue;
      i++;
    }
    return i;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    throw new UnsupportOperationException();
  }

  public String getName()
  {
    return "RuleProject";
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof RulePackage)) || ((paramIElement instanceof Envionment)) || ((paramIElement instanceof RuleGroup)) || ((paramIElement instanceof TestCaseLib));
  }

  public IElement deepClone()
  {
    return new RuleProject(this);
  }

  public void addChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof RuleGroup))
    {
      super.addChildElement(paramIElement, getRuleGroupCount());
    }
    else if ((paramIElement instanceof RulePackage))
    {
      if (b((RulePackage)paramIElement))
        n.a().a(format("hasExitsPackage.error", new String[] { ((RulePackage)paramIElement).getExeRulePackageName() }));
      else
        super.addChildElement(paramIElement, getRuleGroupCount() + getRulePackageCount());
    }
    else if ((paramIElement instanceof TestCaseLib))
    {
      super.addChildElement(paramIElement, getChildrenCount() - 1);
    }
    else if ((paramIElement instanceof Envionment))
    {
      List localList = a();
      for (int i = 0; i < localList.size(); i++)
      {
        if (!(localList.get(i) instanceof Envionment))
          continue;
        ((Envionment)localList.get(i)).dispose();
      }
      super.addChildElement(paramIElement, getChildrenCount());
    }
    else
    {
      super.addChildElement(paramIElement);
    }
  }

  public void addGroupPackage(IRulePackage paramIRulePackage, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      String[] arrayOfString = paramString.split(",");
      RuleGroup localRuleGroup = createGroup(arrayOfString[0]);
      if (arrayOfString.length > 1)
        localRuleGroup = localRuleGroup.getSubGroup(arrayOfString, 1);
      localRuleGroup.addChildElement(paramIRulePackage);
    }
    else
    {
      addChildElement(paramIRulePackage);
    }
  }

  protected boolean b()
  {
    return super.b();
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return ((paramITreeNode instanceof RulePackage)) || ((paramITreeNode instanceof RuleGroup)) || ((paramITreeNode instanceof TestCaseLib));
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return (paramString.equals("RulePackage")) || (paramString.equals("RuleGroup")) || (paramString.equals("TestCaseLib")) || (paramString.equals("Envionment"));
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canUpdate()
  {
    return true;
  }

  public ITreeNode createChildNode(String paramString)
  {
    Object localObject;
    if (paramString.equalsIgnoreCase("RulePackage"))
    {
      localObject = new RulePackage(getChildDefaultName(RulePackage.DISPLAYNAME));
      addChildElement((IElement)localObject);
      ((RulePackage)localObject).setDirPath(getDataDir());
      if (getEnvionment() != null)
        ((RulePackage)localObject).addChildElement(getEnvionment().deepClone());
      else
        ((RulePackage)localObject).addChildElement(Envionment.getEmptyEnvionment());
      ((RulePackage)localObject).getEnvionment().setDisplayName(Envionment.DISPLAYNAME);
      setNeedSave(true);
      if ((getParent() != null) && ((getParent() instanceof RuleRepository)))
        ((RuleRepository)getParent()).setModified(true);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("RuleGroup"))
    {
      localObject = new RuleGroup(getChildDefaultName(RuleGroup.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (getProject() != null)
        getProject().setModified(true);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("TestCaseLib"))
    {
      localObject = new TestCaseLib(getChildDefaultName(TestCaseLib.DISPLAYNAME));
      addChildElement((IElement)localObject);
      if (getProject() != null)
        getProject().setModified(true);
      return localObject;
    }
    if (paramString.equalsIgnoreCase("Envionment"))
    {
      localObject = Envionment.getEmptyEnvionment();
      ((Envionment)localObject).setDisplayName(getChildDefaultName(((Envionment)localObject).getDisplayName()));
      addChildElement((IElement)localObject);
      if (getProject() != null)
        getProject().setModified(true);
      return localObject;
    }
    return (ITreeNode)super.createChildNode(paramString);
  }

  public Iterator getAcceptNodes()
  {
    if (b())
      return super.getAcceptNodes();
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(RulePackage.nodeInfo);
    localArrayList.add(RuleGroup.nodeInfo);
    localArrayList.add(TestCaseLib.nodeInfo);
    return localArrayList.iterator();
  }

  public String getFilePath()
  {
    return this.filePath;
  }

  public boolean isOpened()
  {
    return this.opened;
  }

  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }

  public void setOpened(boolean paramBoolean)
  {
    this.opened = paramBoolean;
  }

  public Map getWritableRuleSet()
  {
    return this.writableRuleSet;
  }

  public boolean isWritable(String paramString)
  {
    return (this.writableRuleSet.get(paramString) != null) && (this.writableRuleSet.get(paramString).toString().equalsIgnoreCase("true"));
  }

  public void setWritable(String paramString, boolean paramBoolean)
  {
    String str = paramBoolean ? "true" : "false";
    this.writableRuleSet.put(paramString, str);
  }

  public static RuleProject createDefault(String paramString)
  {
    RuleProject localRuleProject = new RuleProject(paramString);
    return localRuleProject;
  }

  public RulePackage exitsPackage(String paramString)
  {
    Iterator localIterator = getRulePackages();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof RulePackage)) && (((RulePackage)localObject).getExeRulePackageName().equalsIgnoreCase(paramString)))
        return (RulePackage)localObject;
    }
    return null;
  }

  public RuleGroup createGroup(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((localObject instanceof RuleGroup)) && (((RuleGroup)localObject).getDisplayName().equalsIgnoreCase(paramString)))
        return (RuleGroup)localObject;
    }
    Object localObject = new RuleGroup(paramString);
    addChildElement((IElement)localObject);
    return (RuleGroup)localObject;
  }

  public boolean exitsSamePackage(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = getRulePackages();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RulePackage))
        continue;
      if ((((RulePackage)localObject).getExeRulePackageName().equalsIgnoreCase(paramString)) && (localHashMap.get(((RulePackage)localObject).getExeRulePackageName()) != null))
        return true;
      localHashMap.put(((RulePackage)localObject).getExeRulePackageName(), ((RulePackage)localObject).getExeRulePackageName());
    }
    return false;
  }

  public boolean canChangePackName(IRulePackage paramIRulePackage)
  {
    Iterator localIterator = getRulePackages();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof IRulePackage)) && (localObject != paramIRulePackage) && (((IRulePackage)localObject).getExeRulePackageName().equalsIgnoreCase(paramIRulePackage.getExeRulePackageName())))
        return false;
    }
    return true;
  }

  public boolean open()
  {
    if (getFilePath().length() == 0)
      return false;
    File localFile1 = new File(getFilePath());
    if (localFile1.isDirectory())
      localFile1 = new File(localFile1.getPath(), "default.prj");
    if ((localFile1.exists()) && (localFile1.isFile()))
      try
      {
        ProjectInfo localProjectInfo = (ProjectInfo)new f().load(localFile1);
        setDisplayName(localProjectInfo.getDisplayName());
        setUuid(localProjectInfo.getUuid());
        setDocument(localProjectInfo.getDocument());
        setProjver(localProjectInfo.getProjver());
        setSaveType(localProjectInfo.getSaveType());
        HashMap localHashMap = new HashMap();
        for (int i = 0; i < localProjectInfo.getFilePathNames().size(); i++)
        {
          String str = (String)localProjectInfo.getFilePathNames().get(i);
          if (str.toLowerCase().endsWith(".rpk"))
          {
            try
            {
              File localFile2 = new File(getDataDir(), str);
              if (!localFile2.exists())
                localFile2 = new File(str);
              if ((!localFile2.exists()) || (localHashMap.get(localFile2) != null))
                continue;
              RulePackage localRulePackage = (RulePackage)new d().load(localFile2);
              localRulePackage.setFilePathName(localFile2.getAbsolutePath());
              if (!localFile2.canWrite())
                localRulePackage.setLocked(true);
              if (!m.a().a(localRulePackage.getExeRulePackageName()))
                localRulePackage.setLocked(true);
              if (m.a().e() == 1)
                localRulePackage.setEdittype(RulePackage.EDITER);
              addChildElement(localRulePackage);
              localHashMap.put(localFile2, localFile2);
            }
            catch (XmlParserException localXmlParserException2)
            {
              n.a().a(format("fileFormat.error", new String[] { str }), localXmlParserException2);
            }
            catch (FileNotFoundException localFileNotFoundException2)
            {
              n.a().a(format("fileNotFount.error", new String[] { str }));
            }
          }
          else
          {
            if (!str.toLowerCase().endsWith(".env"))
              continue;
            try
            {
              if (!new File(getDataDir(), str).exists())
                continue;
              addChildElement((Envionment)new c().load(new File(getDataDir(), str)));
            }
            catch (XmlParserException localXmlParserException3)
            {
              n.a().a(format("fileFormat.error", new String[] { str }), localXmlParserException3);
            }
            catch (FileNotFoundException localFileNotFoundException3)
            {
              n.a().a(format("fileNotFount.error", new String[] { str }));
            }
          }
        }
        List localList = localProjectInfo.getPackageInfos();
        for (int j = 0; j < localList.size(); j++)
          if ((localList.get(j) instanceof PackageInfo))
          {
            a(this, (PackageInfo)localList.get(j));
          }
          else if ((localList.get(j) instanceof GroupInfo))
          {
            a(this, (GroupInfo)localList.get(j));
          }
          else if ((localList.get(j) instanceof TestLibInfo))
          {
            a(this, (TestLibInfo)localList.get(j));
          }
          else
          {
            if (!(localList.get(j) instanceof EnvionmentInfo))
              continue;
            a(this, (EnvionmentInfo)localList.get(j));
          }
        if (new File(localFile1.getParent(), "~lock.tmp").exists())
        {
          setLocked(true);
          n.a().c(localFile1.getPath() + "the project is read only!");
          break label805;
        }
        try
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(new File(localFile1.getParent(), "~lock.tmp"));
          localFileOutputStream.write("locked".getBytes());
          localFileOutputStream.close();
        }
        catch (Exception localException)
        {
        }
      }
      catch (XmlParserException localXmlParserException1)
      {
        n.a().a(localFile1.getPath(), localXmlParserException1);
        d();
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        n.a().a(format("fileNotFount.error", new String[] { localFile1.getPath() }));
        d();
      }
    else
      d();
    label805: getEnvionment();
    setOpened(true);
    if ((getParent() instanceof RuleRepository))
      ((RuleRepository)getParent()).removeClosed(getFilePath());
    return true;
  }

  private void a(ITreeNode paramITreeNode, GroupInfo paramGroupInfo)
  {
    RuleGroup localRuleGroup = new RuleGroup(paramGroupInfo.getDisplayName());
    paramITreeNode.addChildElement(localRuleGroup);
    List localList = paramGroupInfo.getPackageInfos();
    for (int i = 0; i < localList.size(); i++)
      if ((localList.get(i) instanceof PackageInfo))
      {
        a(localRuleGroup, (PackageInfo)localList.get(i));
      }
      else if ((localList.get(i) instanceof GroupInfo))
      {
        a(localRuleGroup, (GroupInfo)localList.get(i));
      }
      else if ((localList.get(i) instanceof TestLibInfo))
      {
        a(localRuleGroup, (TestLibInfo)localList.get(i));
      }
      else
      {
        if (!(localList.get(i) instanceof EnvionmentInfo))
          continue;
        a(localRuleGroup, (EnvionmentInfo)localList.get(i));
      }
  }

  private void a(ITreeNode paramITreeNode, TestLibInfo paramTestLibInfo)
  {
    String str = paramTestLibInfo.getFileName();
    if (str.toLowerCase().endsWith(".test"))
      try
      {
        File localFile = new File(getTestDir(), str);
        if (!localFile.exists())
          localFile = new File(str);
        if (localFile.exists())
        {
          TestCaseLib localTestCaseLib = (TestCaseLib)new z().load(localFile);
          paramITreeNode.addChildElement(localTestCaseLib);
        }
      }
      catch (XmlParserException localXmlParserException)
      {
        n.a().a(format("fileFormat.error", new String[] { str }), localXmlParserException);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        n.a().a(format("fileNotFount.error", new String[] { str }));
      }
  }

  private void a(ITreeNode paramITreeNode, EnvionmentInfo paramEnvionmentInfo)
  {
    String str = paramEnvionmentInfo.getFileName();
    if (str.toLowerCase().endsWith(".env"))
      try
      {
        File localFile = new File(getDataDir(), str);
        if (!localFile.exists())
          localFile = new File(str);
        if (localFile.exists())
        {
          Envionment localEnvionment = (Envionment)new c().load(localFile);
          paramITreeNode.addChildElement(localEnvionment);
        }
      }
      catch (XmlParserException localXmlParserException)
      {
        n.a().a(format("fileFormat.error", new String[] { str }), localXmlParserException);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        n.a().a(format("fileNotFount.error", new String[] { str }));
      }
  }

  private void a(ITreeNode paramITreeNode, PackageInfo paramPackageInfo)
  {
    File localFile1 = new File(getSrcDir() + File.separator + paramPackageInfo.getDisplayName() + "." + "RulePackage");
    Object localObject1;
    Object localObject2;
    if ((getSaveType() == 0) || (!localFile1.exists()))
    {
      localObject1 = paramPackageInfo.getFileName();
      if (((String)localObject1).toLowerCase().endsWith(".rpk"))
        try
        {
          File localFile2 = new File(getDataDir(), (String)localObject1);
          if (!localFile2.exists())
            localFile2 = new File((String)localObject1);
          if (!localFile2.exists())
            return;
          localObject2 = (RulePackage)new d().load(localFile2);
          ((RulePackage)localObject2).setFilePathName(localFile2.getAbsolutePath());
          ((RulePackage)localObject2).setCheckType(paramPackageInfo.getCheckType());
          ((RulePackage)localObject2).setLocked(paramPackageInfo.isLocked());
          if (!localFile2.canWrite())
            ((RulePackage)localObject2).setLocked(true);
          if (!m.a().a(((RulePackage)localObject2).getExeRulePackageName()))
            ((RulePackage)localObject2).setLocked(true);
          if (m.a().e() == 1)
            ((RulePackage)localObject2).setEdittype(RulePackage.EDITER);
          paramITreeNode.addChildElement((IElement)localObject2);
        }
        catch (XmlParserException localXmlParserException)
        {
          n.a().a(format("fileFormat.error", new String[] { localObject1 }), localXmlParserException);
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          n.a().a(format("fileNotFount.error", new String[] { localObject1 }));
        }
    }
    else
    {
      try
      {
        localObject1 = (ParentInfo)new s().load(localFile1);
        RulePackage localRulePackage = (RulePackage)((ParentInfo)localObject1).getElements();
        if (!m.a().a(localRulePackage.getExeRulePackageName()))
          localRulePackage.setLocked(true);
        if (m.a().e() == 1)
          localRulePackage.setEdittype(RulePackage.EDITER);
        paramITreeNode.addChildElement(localRulePackage);
        localObject2 = ((ParentInfo)localObject1).getChildNodeInfos();
        for (int i = 0; i < ((List)localObject2).size(); i++)
        {
          ChildNodeInfo localChildNodeInfo = (ChildNodeInfo)((List)localObject2).get(i);
          localChildNodeInfo.loadFromFile(localRulePackage, localRulePackage.getSrcPath());
        }
      }
      catch (Exception localException)
      {
        n.a().a(format("fileFormat.error", new String[] { localFile1.getAbsolutePath() }), localException);
      }
    }
  }

  private void d()
  {
    File localFile = new File(getDataDir());
    if (localFile.isDirectory())
    {
      File[] arrayOfFile = localFile.listFiles();
      for (int i = 0; i < arrayOfFile.length; i++)
        if (arrayOfFile[i].getName().toLowerCase().endsWith(".rpk"))
        {
          RulePackage localRulePackage = (RulePackage)new d().load(arrayOfFile[i]);
          localRulePackage.setFilePathName(arrayOfFile[i].getPath());
          if (!m.a().a(localRulePackage.getExeRulePackageName()))
            localRulePackage.setLocked(true);
          if (m.a().e() == 1)
            localRulePackage.setEdittype(RulePackage.EDITER);
          addChildElement(localRulePackage);
        }
        else if (arrayOfFile[i].getName().toLowerCase().endsWith(".env"))
        {
          addChildElement((Envionment)new c().load(arrayOfFile[i]));
        }
        else
        {
          if (!arrayOfFile[i].getName().toLowerCase().endsWith(".test"))
            continue;
          addChildElement((TestCaseLib)new z().load(arrayOfFile[i]));
        }
    }
  }

  public List getClosedPackages()
  {
    File localFile = new File(getDataDir());
    ArrayList localArrayList = new ArrayList();
    if (localFile.isDirectory())
    {
      File[] arrayOfFile = localFile.listFiles();
      for (int i = 0; i < arrayOfFile.length; i++)
        if (arrayOfFile[i].isDirectory())
        {
          a(localArrayList, arrayOfFile[i], arrayOfFile[i].getName());
        }
        else
        {
          if ((!arrayOfFile[i].getName().toLowerCase().endsWith(".rpk")) || (a(arrayOfFile[i].getName().substring(0, arrayOfFile[i].getName().length() - ".rpk".length()))))
            continue;
          a(localArrayList, arrayOfFile[i]);
        }
    }
    return localArrayList;
  }

  private void a(List paramList, File paramFile, String paramString)
  {
    File[] arrayOfFile = paramFile.listFiles();
    for (int i = 0; i < arrayOfFile.length; i++)
      if (arrayOfFile[i].isDirectory())
      {
        a(paramList, arrayOfFile[i], paramString + "." + arrayOfFile[i].getName());
      }
      else
      {
        if ((!arrayOfFile[i].getName().toLowerCase().endsWith(".rpk")) || (a(paramString + "." + arrayOfFile[i].getName().substring(0, arrayOfFile[i].getName().length() - ".rpk".length()))))
          continue;
        a(paramList, arrayOfFile[i]);
      }
  }

  private void a(List paramList, File paramFile)
  {
    RulePackage localRulePackage = (RulePackage)new d().load(paramFile);
    localRulePackage.setFilePathName(paramFile.getPath());
    if (!m.a().a(localRulePackage.getExeRulePackageName()))
      localRulePackage.setLocked(true);
    if (m.a().e() == 1)
      localRulePackage.setEdittype(RulePackage.EDITER);
    paramList.add(localRulePackage);
  }

  public String getBakDir()
  {
    return getParentDir() + File.separator + "bak";
  }

  public String getSrcDir()
  {
    return getParentDir() + File.separator + "src";
  }

  public String getDataDir()
  {
    return getParentDir() + File.separator + "data";
  }

  public String getTestDir()
  {
    return getParentDir() + File.separator + "test";
  }

  public String getRmkDir()
  {
    return getParentDir() + File.separator + "rmk";
  }

  public void createDirectory()
  {
    File localFile = new File(getParentDir());
    if (!localFile.exists())
      localFile.mkdirs();
    localFile = new File(getParentDir() + File.separator + "bak");
    if (!localFile.exists())
      localFile.mkdirs();
    localFile = new File(getParentDir() + File.separator + "data");
    if (!localFile.exists())
      localFile.mkdirs();
    localFile = new File(getParentDir() + File.separator + "test");
    if (!localFile.exists())
      localFile.mkdirs();
    if (getSaveType() == 1)
    {
      localFile = new File(getParentDir() + File.separator + "src");
      localFile.mkdirs();
    }
  }

  public String getParentDir()
  {
    if (new File(getFilePath()).isDirectory())
      return getFilePath();
    File localFile = new File(getFilePath()).getParentFile();
    return localFile.getPath();
  }

  public boolean paste(IElement paramIElement)
  {
    if (((paramIElement instanceof ITreeNode)) && (acceptNode((ITreeNode)paramIElement)))
    {
      super.paste((ITreeNode)paramIElement);
      if ((paramIElement instanceof RulePackage))
        ((RulePackage)paramIElement).setDirPath(getDataDir());
      setModified(true);
      updateTree();
      return true;
    }
    if ((paramIElement instanceof ElementContainer))
    {
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        super.paste((IElement)localObject);
        if ((!(localObject instanceof RulePackage)) || (getProject() == null))
          continue;
        ((RulePackage)localObject).setDirPath(getProject().getDataDir());
      }
      setModified(true);
      updateTree();
      return true;
    }
    return false;
  }

  public void save(RulePackage paramRulePackage, boolean paramBoolean)
  {
    if (paramRulePackage.isNeedSave())
    {
      Object localObject;
      if (paramBoolean)
      {
        if (paramRulePackage.getAutoSaveTime() < paramRulePackage.getMaxModifyTime())
        {
          new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString()).mkdirs();
          localObject = new e(new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString(), paramRulePackage.getFileName() + ".rpk.autosave"));
          ((e)localObject).a(paramRulePackage);
          ((e)localObject).close();
          paramRulePackage.setAutoSaveTime(System.currentTimeMillis());
        }
      }
      else
      {
        if (exitsSamePackage(paramRulePackage.getExeRulePackageName()))
          throw new y(u.a("samepackage.error") + paramRulePackage.getExeRulePackageName());
        try
        {
          new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString()).mkdirs();
          localObject = new File(paramRulePackage.getFilePathName());
          if ((localObject == null) || (!((File)localObject).exists()))
            localObject = new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString(), paramRulePackage.getFileName() + ".rpk.autosave");
          if (((File)localObject).exists())
            FileUtil.copy((File)localObject, new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString(), paramRulePackage.getFileName() + ".rpk" + "~" + a(paramRulePackage) + "~"), true);
          if (new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString(), paramRulePackage.getFileName() + ".rpk.autosave").exists())
            new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString(), paramRulePackage.getFileName() + ".rpk.autosave").delete();
        }
        catch (FileExistsException localFileExistsException)
        {
        }
        catch (IOException localIOException)
        {
        }
        paramRulePackage.selfSave();
      }
    }
    else if ((isMultiFileSave()) && (!paramBoolean))
    {
      if (exitsSamePackage(paramRulePackage.getExeRulePackageName()))
        throw new y(u.a("samepackage.error") + paramRulePackage.getExeRulePackageName());
      paramRulePackage.selfSave();
    }
  }

  public void save(Envionment paramEnvionment, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      if (paramEnvionment.isModified())
      {
        File localFile1 = new File(getParentDir());
        if (!localFile1.exists())
          localFile1.mkdirs();
        localFile1 = new File(getParentDir() + File.separator + "bak");
        if (!localFile1.exists())
          localFile1.mkdirs();
        localObject = new e(new File(getBakDir(), paramEnvionment.getDisplayName() + ".env.autosave"));
        ((e)localObject).a(paramEnvionment);
        ((e)localObject).close();
        paramEnvionment.setAutoSaveTime(System.currentTimeMillis());
      }
    }
    else
    {
      try
      {
        if (new File(getDataDir() + File.separator + paramEnvionment.getDisplayName() + ".env").exists())
          FileUtil.copy(new File(getDataDir() + File.separator + paramEnvionment.getDisplayName() + ".env"), new File(getBakDir(), paramEnvionment.getDisplayName() + ".env" + "~" + a(paramEnvionment.getDisplayName(), ".env~") + "~"), true);
      }
      catch (FileExistsException localFileExistsException)
      {
      }
      catch (IOException localIOException)
      {
      }
      e.a(paramEnvionment, new File(getDataDir(), paramEnvionment.getDisplayName() + ".env"));
      if (new File(getBakDir(), paramEnvionment.getDisplayName() + ".env.autosave").exists())
        new File(getBakDir(), paramEnvionment.getDisplayName() + ".env.autosave").delete();
      Iterator localIterator = paramEnvionment.getAcceptChildren(new av(this));
      while (localIterator.hasNext())
      {
        localObject = (IRuleTree)localIterator.next();
        File localFile2 = new File(getRmkDir(), paramEnvionment.getDisplayName());
        if (!localFile2.exists())
          localFile2.mkdirs();
        e.a((IRuleTree)localObject, new File(getRmkDir() + "/" + paramEnvionment.getDisplayName(), ((IRuleTree)localObject).getDisplayName() + ".rmk"));
      }
      paramEnvionment.setModified(false);
    }
  }

  public void save(TestCaseLib paramTestCaseLib, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramTestCaseLib.isModified())
      {
        File localFile = new File(getParentDir());
        if (!localFile.exists())
          localFile.mkdirs();
        localFile = new File(getParentDir() + File.separator + "bak");
        if (!localFile.exists())
          localFile.mkdirs();
        e locale2 = new e(new File(getBakDir(), paramTestCaseLib.getFilePathName() + ".autosave"));
        locale2.a(paramTestCaseLib);
        locale2.close();
        paramTestCaseLib.setAutoSaveTime(System.currentTimeMillis());
      }
    }
    else
    {
      try
      {
        if (new File(getTestDir() + File.separator + paramTestCaseLib.getFilePathName()).exists())
          FileUtil.copy(new File(getTestDir() + File.separator + paramTestCaseLib.getFilePathName()), new File(getBakDir(), paramTestCaseLib.getFilePathName() + "~" + a(paramTestCaseLib.getFilePathName(), "~") + "~"), true);
      }
      catch (FileExistsException localFileExistsException)
      {
      }
      catch (IOException localIOException)
      {
      }
      e locale1 = new e(new File(getTestDir(), paramTestCaseLib.getFilePathName()));
      locale1.a(paramTestCaseLib);
      locale1.close();
      if (new File(getBakDir(), paramTestCaseLib.getFilePathName() + ".autosave").exists())
        new File(getBakDir(), paramTestCaseLib.getFilePathName() + ".autosave").delete();
      paramTestCaseLib.setModified(false);
    }
  }

  public void save()
  {
    createDirectory();
    Iterator localIterator = getAcceptElements(new aw(this));
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof RulePackage))
      {
        save((RulePackage)localObject, false);
      }
      else if ((localObject instanceof TestCaseLib))
      {
        save((TestCaseLib)localObject, false);
      }
      else
      {
        if (!(localObject instanceof Envionment))
          continue;
        save((Envionment)localObject, false);
      }
    }
    if (isOpened())
      selfSave();
    if ((getParent() != null) && ((getParent() instanceof RuleRepository)))
      ((RuleRepository)getParent()).selfSave();
    setModified(false);
  }

  private int a(RulePackage paramRulePackage)
  {
    File localFile = new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString());
    int i = 1;
    if (localFile.isDirectory())
      while (new File(localFile.getPath(), paramRulePackage.getFileName() + ".rpk~" + i + "~").exists())
        i++;
    return i;
  }

  private int a(String paramString1, String paramString2)
  {
    File localFile = new File(getParentDir() + File.separator + "bak");
    int i = 1;
    if (localFile.isDirectory())
    {
      File[] arrayOfFile = localFile.listFiles();
      for (int j = 0; j < arrayOfFile.length; j++)
      {
        if (arrayOfFile[j].getName().indexOf(paramString1 + paramString2) <= 0)
          continue;
        i++;
      }
    }
    return i;
  }

  public void autoSave()
  {
    Iterator localIterator = getAcceptElements(new ax(this));
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof RulePackage))
      {
        save((RulePackage)localObject, true);
      }
      else
      {
        if (!(localObject instanceof Envionment))
          continue;
        save((Envionment)localObject, true);
      }
    }
  }

  public void selfSave()
  {
    createDirectory();
    if (!new File(getFilePath()).exists())
      new File(getFilePath()).createNewFile();
    g localg = new g(new File(getFilePath()));
    localg.a(this);
    localg.close();
    this.autoSaveTime = System.currentTimeMillis();
    this.d = false;
  }

  public void setModified(boolean paramBoolean)
  {
    try
    {
      if (paramBoolean)
      {
        selfSave();
        if ((getParent() != null) && (((getParent() instanceof RuleRepository)) || ((getParent() instanceof IRuleProject)) || ((getParent() instanceof RuleProject))))
          ((ITreeNode)getParent()).setModified(true);
      }
    }
    catch (Exception localException)
    {
    }
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
    return this.d;
  }

  public boolean isNeedSave()
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof ITreeNode)) && (((ITreeNode)localObject).isNeedSave()))
        return true;
    }
    return this.d;
  }

  public void getHistoryPack(List paramList, File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      for (int i = 0; i < arrayOfFile.length; i++)
        if ((arrayOfFile[i].exists()) && (arrayOfFile[i].isFile()))
        {
          if (arrayOfFile[i].getName().indexOf(".rpk~") < 0)
            continue;
          try
          {
            if (arrayOfFile[i].getPath().indexOf(getBakDir()) < 0)
              continue;
            int j = arrayOfFile[i].getPath().indexOf(getBakDir()) + getBakDir().length() + 1;
            String str = arrayOfFile[i].getPath().substring(j, arrayOfFile[i].getPath().lastIndexOf(".rpk~")).replace(File.separatorChar, '.');
            if (a(str))
              continue;
            ArrayList localArrayList = new ArrayList(3);
            localArrayList.add(str);
            localArrayList.add(String.valueOf(arrayOfFile[i].lastModified()));
            localArrayList.add(arrayOfFile[i].getPath());
            paramList.add(localArrayList);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
        else
        {
          if ((!arrayOfFile[i].exists()) || (!arrayOfFile[i].isDirectory()))
            continue;
          getHistoryPack(paramList, arrayOfFile[i]);
        }
    }
  }

  public String getExeName(File paramFile)
  {
    String str = paramFile.getAbsolutePath();
    str.indexOf(getBakDir());
    return "";
  }

  public List getHistoryPack()
  {
    File localFile = new File(getBakDir());
    ArrayList localArrayList = new ArrayList();
    getHistoryPack(localArrayList, localFile);
    return localArrayList;
  }

  public List getAutoSavedPack()
  {
    ArrayList localArrayList1 = new ArrayList();
    if (isLocked())
      return localArrayList1;
    Iterator localIterator = getRulePackages();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RulePackage))
        continue;
      File localFile = new File(getBakDir() + File.separator + ((RulePackage)localObject).getPackageDirString(), ((RulePackage)localObject).getFileName() + ".rpk.autosave");
      if (!localFile.exists())
        localFile = new File(getBakDir() + File.separator + ((RulePackage)localObject).getPackageDirString(), ((RulePackage)localObject).getFileName() + ".rpk.backup");
      if (!localFile.exists())
        continue;
      int i = getBakDir().length() + File.separator.length();
      String str = localFile.getPath().substring(i, localFile.getPath().lastIndexOf(".rpk")).replace(File.separatorChar, '.');
      if (!a(str))
        continue;
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(str);
      localArrayList2.add(String.valueOf(localFile.lastModified()));
      localArrayList2.add(localFile.getPath());
      localArrayList1.add(localArrayList2);
    }
    return localArrayList1;
  }

  private boolean b(RulePackage paramRulePackage)
  {
    Iterator localIterator = getRulePackages();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof RulePackage)) && ((((RulePackage)localObject).getUuid().equals(paramRulePackage.getUuid())) || (((RulePackage)localObject).getExeRulePackageName().equalsIgnoreCase(paramRulePackage.getExeRulePackageName()))))
        return true;
    }
    return false;
  }

  private boolean a(String paramString)
  {
    Iterator localIterator = getRulePackages();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof RulePackage)) && (((RulePackage)localObject).getExeRulePackageName().equals(paramString)))
        return true;
    }
    return false;
  }

  public boolean recoverAutoSavePack(List paramList)
  {
    Iterator localIterator = getRulePackages();
    Object localObject;
    File localFile;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((!(localObject instanceof RulePackage)) || (!((RulePackage)localObject).getExeRulePackageName().equals(paramList.get(0))) || (!new File(paramList.get(2).toString()).exists()))
        continue;
      ((RulePackage)localObject).recoverAutoSavePack(paramList);
      localFile = new File(paramList.get(2).toString());
      if (localFile.exists())
        localFile.delete();
      return true;
    }
    if (new File(paramList.get(2).toString()).exists())
      try
      {
        localObject = (RulePackage)new d().load(new File(paramList.get(2).toString()));
        if (!m.a().a(((RulePackage)localObject).getExeRulePackageName()))
          ((RulePackage)localObject).setLocked(true);
        if (m.a().e() == 1)
          ((RulePackage)localObject).setEdittype(RulePackage.EDITER);
        addChildElement((IElement)localObject);
        ((RulePackage)localObject).setDirPath("");
        ((RulePackage)localObject).setFilePathName("");
        ((RulePackage)localObject).setNeedSave(true);
        ((RulePackage)localObject).setDirPath(getDataDir());
        localFile = new File(getBakDir() + File.separator + ((RulePackage)localObject).getPackageDirString(), ((RulePackage)localObject).getFileName() + ".rpk.autosave");
        if (localFile.exists())
          localFile.delete();
        localFile = new File(getBakDir() + File.separator + ((RulePackage)localObject).getPackageDirString(), ((RulePackage)localObject).getFileName() + ".rpk.backup");
        if (localFile.exists())
          localFile.delete();
        setNeedSave(true);
        updateTree();
      }
      catch (Exception localException)
      {
        n.a().b(paramList.get(2).toString() + " is error!", localException);
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
      autoSave();
    }
    catch (Exception localException)
    {
    }
    e();
    Iterator localIterator = getAcceptElements(new ay(this));
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof RulePackage))
      {
        clearAutoSave((RulePackage)localObject);
      }
      else
      {
        if (!(localObject instanceof Envionment))
          continue;
        File localFile = new File(getBakDir(), ((Envionment)localObject).getDisplayName() + ".env.autosave");
        if (!localFile.exists())
          continue;
        localFile.delete();
      }
    }
  }

  public void clearAutoSave(RulePackage paramRulePackage)
  {
    File localFile = new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString(), paramRulePackage.getFileName() + ".rpk.autosave");
    if (localFile.exists())
      localFile.delete();
  }

  public boolean isLocked()
  {
    return false;
  }

  public void dispose()
  {
    RuleRepository localRuleRepository = null;
    if ((getParent() != null) && ((getParent() instanceof RuleRepository)))
      localRuleRepository = (RuleRepository)getParent();
    setOpened(false);
    e();
    super.dispose();
    if (localRuleRepository != null)
    {
      localRuleRepository.setModified(true);
      localRuleRepository.setNeedSave(true);
    }
  }

  public void close()
  {
    RuleRepository localRuleRepository = null;
    if ((getParent() != null) && ((getParent() instanceof RuleRepository)))
      localRuleRepository = (RuleRepository)getParent();
    setOpened(false);
    e();
    disposeAllViewer();
    setElementEditor(null);
    for (int i = a().size() - 1; i >= 0; i--)
      ((IElement)a().get(i)).dispose();
    a().clear();
    if (localRuleRepository != null)
      localRuleRepository.setNeedSave(true);
  }

  private void e()
  {
    if (!isLocked())
    {
      File localFile = new File(getFilePath());
      if (localFile.isDirectory())
        localFile = new File(localFile.getPath(), "default.prj");
      if (new File(localFile.getParent(), "~lock.tmp").exists())
      {
        new File(localFile.getParent(), "~lock.tmp").delete();
        try
        {
          Thread.currentThread();
          Thread.sleep(100L);
        }
        catch (Exception localException)
        {
        }
      }
    }
  }

  public void disposeAndUpdate()
  {
    RuleRepository localRuleRepository = null;
    if ((getParent() != null) && ((getParent() instanceof RuleRepository)))
      localRuleRepository = (RuleRepository)getParent();
    setOpened(false);
    e();
    super.dispose();
    if (localRuleRepository != null)
    {
      localRuleRepository.setNeedSave(true);
      localRuleRepository.updateTree();
    }
  }

  public boolean isVisible()
  {
    return true;
  }

  public IRuleProject getProject()
  {
    return this;
  }

  public IRuleRepository getRepository()
  {
    if ((getParent() != null) && ((getParent() instanceof RuleRepository)))
      return (RuleRepository)getParent();
    return null;
  }

  public String toString()
  {
    return getDisplayName();
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
      localException.printStackTrace();
    }
  }

  public void setLocked(boolean paramBoolean)
  {
    this.locked = paramBoolean;
  }

  public List getClosedNode()
  {
    return new ArrayList(0);
  }

  public int getSaveType()
  {
    return this.saveType;
  }

  public void setSaveType(int paramInt)
  {
    this.saveType = paramInt;
  }

  public boolean isMultiFileSave()
  {
    return this.saveType == 1;
  }

  public long getModifyTime()
  {
    return super.getMaxModifyTime();
  }

  public String getProjver()
  {
    return this.projver;
  }

  public void setProjver(String paramString)
  {
    this.projver = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RuleProject
 * JD-Core Version:    0.6.0
 */
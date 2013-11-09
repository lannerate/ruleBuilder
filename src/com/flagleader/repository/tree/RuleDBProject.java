package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.u;
import com.flagleader.repository.d.y;
import com.flagleader.repository.e.e;
import com.flagleader.util.exception.UnsupportOperationException;
import com.flagleader.util.filesystem.FileExistsException;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.SystemUtils;

public class RuleDBProject extends AbstractTreeNode
  implements IRuleGroup, IRuleProject
{
  public static final String NAME = "RuleDBProject";
  public static final String DISPLAYNAME = getLocalString("RuleDBProject.text");
  public static final NodeInfo nodeInfo = new NodeInfo("RuleDBProject", DISPLAYNAME, DISPLAYNAME);
  private String filePath = null;
  private String projver = "";

  public RuleDBProject()
  {
  }

  public RuleDBProject(String paramString)
  {
    setDisplayName(paramString);
  }

  public RuleDBProject(RuleDBProject paramRuleDBProject)
  {
    super(paramRuleDBProject);
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
    return getAcceptElements(new aq(this));
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
    return "RuleDBProject";
  }

  protected boolean a(IElement paramIElement)
  {
    return ((paramIElement instanceof RulePackage)) || ((paramIElement instanceof Envionment)) || ((paramIElement instanceof RuleGroup));
  }

  public IElement deepClone()
  {
    return new RuleDBProject(this);
  }

  public void addChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof RuleGroup))
      super.addChildElement(paramIElement, getRuleGroupCount());
    else if ((paramIElement instanceof RulePackage))
      super.addChildElement(paramIElement, getRuleGroupCount() + getRulePackageCount());
    else
      super.addChildElement(paramIElement);
  }

  protected boolean b()
  {
    return super.b();
  }

  public boolean acceptNode(ITreeNode paramITreeNode)
  {
    if (b())
      return false;
    return ((paramITreeNode instanceof RulePackage)) || ((paramITreeNode instanceof RuleGroup));
  }

  public boolean acceptNode(String paramString)
  {
    if (b())
      return false;
    return (paramString.equals("RulePackage")) || (paramString.equals("RuleGroup"));
  }

  public boolean canCopy()
  {
    return false;
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
    return (ITreeNode)super.createChildNode(paramString);
  }

  public Iterator getAcceptNodes()
  {
    if (b())
      return super.getAcceptNodes();
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(RulePackage.nodeInfo);
    localArrayList.add(RuleGroup.nodeInfo);
    return localArrayList.iterator();
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

  public boolean paste(IElement paramIElement)
  {
    if (((paramIElement instanceof ITreeNode)) && (acceptNode((ITreeNode)paramIElement)))
    {
      super.paste(paramIElement);
      if ((paramIElement instanceof RulePackage))
        ((RulePackage)paramIElement).setDirPath(getDataDir());
      setModified(true);
      setNeedSave(true);
      updateTree();
      return true;
    }
    return false;
  }

  public void save(RulePackage paramRulePackage, boolean paramBoolean)
  {
    if (paramRulePackage.isModified())
      if (paramBoolean)
      {
        if (paramRulePackage.getAutoSaveTime() < paramRulePackage.getMaxModifyTime())
        {
          new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString()).mkdirs();
          File localFile = new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString(), paramRulePackage.getFileName() + ".rpk.autosave");
          e locale = new e(localFile);
          locale.a(paramRulePackage);
          locale.close();
          paramRulePackage.setAutoSaveTime(System.currentTimeMillis());
        }
      }
      else
      {
        if (exitsSamePackage(paramRulePackage.getExeRulePackageName()))
          throw new y(u.a("samepackage.error"));
        try
        {
          new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString()).mkdirs();
          FileUtil.copy(new File(paramRulePackage.getFilePathName()), new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString(), paramRulePackage.getFileName() + ".rpk" + "~" + a(paramRulePackage) + "~"), true);
          new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString(), paramRulePackage.getFileName() + ".rpk.autosave").deleteOnExit();
        }
        catch (FileExistsException localFileExistsException)
        {
        }
        catch (IOException localIOException)
        {
        }
        paramRulePackage.selfSave();
        if ((getRepository() != null) && (getRepository().getRuleServer() != null))
          getRepository().getRuleServer().a(paramRulePackage, getDisplayName());
      }
  }

  public void save(TestCaseLib paramTestCaseLib, boolean paramBoolean)
  {
    File localFile;
    e locale;
    if (paramBoolean)
    {
      if (paramTestCaseLib.getAutoSaveTime() < paramTestCaseLib.getMaxModifyTime())
      {
        localFile = new File(getBakDir(), paramTestCaseLib.getDisplayName() + ".test.autosave");
        locale = new e(localFile);
        locale.a(paramTestCaseLib);
        locale.close();
        paramTestCaseLib.setAutoSaveTime(System.currentTimeMillis());
      }
    }
    else
    {
      localFile = new File(getTestDir(), paramTestCaseLib.getDisplayName() + ".test");
      locale = new e(localFile);
      locale.a(paramTestCaseLib);
      locale.close();
      new File(getBakDir(), paramTestCaseLib.getDisplayName() + ".test.autosave").deleteOnExit();
      paramTestCaseLib.setModified(false);
    }
  }

  public void save(Envionment paramEnvionment, boolean paramBoolean)
  {
    File localFile;
    e locale;
    if (paramBoolean)
    {
      if (paramEnvionment.getAutoSaveTime() < paramEnvionment.getMaxModifyTime())
      {
        localFile = new File(getBakDir(), paramEnvionment.getDisplayName() + ".env.autosave");
        locale = new e(localFile);
        locale.a(paramEnvionment);
        locale.close();
        paramEnvionment.setAutoSaveTime(System.currentTimeMillis());
      }
    }
    else
    {
      localFile = new File(getDataDir(), paramEnvionment.getDisplayName() + ".env");
      locale = new e(localFile);
      locale.a(paramEnvionment);
      locale.close();
      new File(getBakDir(), paramEnvionment.getDisplayName() + ".env.autosave").deleteOnExit();
      paramEnvionment.setModified(false);
    }
  }

  public void save()
  {
    createDirectory();
    Iterator localIterator = getRulePackages();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RulePackage))
        continue;
      save((RulePackage)localObject, false);
    }
    if (getEnvionment() != null)
      save(getEnvionment(), false);
    if ((getParent() != null) && ((getParent() instanceof RuleRepository)))
      ((RuleRepository)getParent()).selfSave();
    setModified(false);
  }

  private int a(RulePackage paramRulePackage)
  {
    File localFile = new File(getBakDir() + File.separator + paramRulePackage.getPackageDirString());
    int i = 1;
    if (localFile.isDirectory())
    {
      File[] arrayOfFile = localFile.listFiles();
      for (int j = 0; j < arrayOfFile.length; j++)
      {
        if (arrayOfFile[j].getName().indexOf(paramRulePackage.getFileName() + ".rpk~") < 0)
          continue;
        i++;
      }
    }
    return i;
  }

  public void autoSave()
  {
    Iterator localIterator = getRulePackages();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof RulePackage))
        continue;
      save((RulePackage)localObject, true);
    }
    if (getEnvionment() != null)
      save(getEnvionment(), true);
    this.d = false;
  }

  public void selfSave()
  {
    createDirectory();
  }

  public void setModified(boolean paramBoolean)
  {
    if (paramBoolean)
      selfSave();
    this.d = true;
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

  public void clearAutoSave()
  {
    try
    {
      autoSave();
    }
    catch (Exception localException)
    {
    }
    d();
    Iterator localIterator = getRulePackages();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof RulePackage))
        continue;
      clearAutoSave((RulePackage)localObject);
    }
    if (getEnvionment() != null)
    {
      localObject = new File(getBakDir(), getEnvionment().getDisplayName() + ".env.autosave");
      if (((File)localObject).exists())
        ((File)localObject).delete();
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
    d();
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
    d();
    disposeAllViewer();
    setElementEditor(null);
    for (int i = a().size() - 1; i >= 0; i--)
      ((IElement)a().get(i)).dispose();
    clearAllChildren();
    if (localRuleRepository != null)
    {
      localRuleRepository.setModified(true);
      localRuleRepository.setNeedSave(true);
    }
  }

  private void d()
  {
  }

  public void disposeAndUpdate()
  {
    RuleRepository localRuleRepository = null;
    if ((getParent() != null) && ((getParent() instanceof RuleRepository)))
      localRuleRepository = (RuleRepository)getParent();
    d();
    super.dispose();
    if (localRuleRepository != null)
    {
      localRuleRepository.setModified(true);
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

  public List getClosedNode()
  {
    return new ArrayList();
  }

  public String getFilePath()
  {
    if (this.filePath == null)
      return SystemUtils.USER_HOME + File.separator + ".visualrules" + File.separator + "rules" + File.separator + getDisplayName();
    return this.filePath;
  }

  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }

  public String getBakDir()
  {
    return getFilePath() + File.separator + "bak";
  }

  public String getDataDir()
  {
    return getFilePath() + File.separator + "data";
  }

  public String getTestDir()
  {
    return getFilePath() + File.separator + "test";
  }

  public void createDirectory()
  {
    File localFile = new File(getDataDir());
    localFile.mkdirs();
    localFile = new File(getBakDir());
    localFile.mkdirs();
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

  public void backup(List paramList)
  {
  }

  public void clearBackup(List paramList)
  {
  }

  public List getAutoSavedPack()
  {
    return new ArrayList(0);
  }

  public boolean recoverAutoSavePack(List paramList)
  {
    return false;
  }

  public boolean isMultiFileSave()
  {
    return false;
  }

  public String getSrcDir()
  {
    return getFilePath() + File.separator + "src";
  }

  public String getProjver()
  {
    return this.projver;
  }

  public void setProjver(String paramString)
  {
    this.projver = paramString;
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RuleDBProject
 * JD-Core Version:    0.6.0
 */
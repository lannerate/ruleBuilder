package com.flagleader.repository.export;

import com.flagleader.export.ExportAction;
import com.flagleader.export.IExportElement;
import com.flagleader.export.IExportField;
import com.flagleader.export.PagePropertyPool;
import com.flagleader.export.PagesMessages;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.AbstractPackageElement;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.JspUtil;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class AbstractPage extends AbstractPackageElement
  implements IPage
{
  private String modelStr = "";
  private String exportFile = "";
  protected String a;
  private String title = "";

  public AbstractPage(AbstractPage paramAbstractPage)
  {
    super(paramAbstractPage);
    this.modelStr = paramAbstractPage.modelStr;
    this.a = paramAbstractPage.a;
    this.title = paramAbstractPage.title;
  }

  public AbstractPage()
  {
    this.a = "simple/page_all.rsp";
  }

  public AbstractPage(String paramString)
  {
    super(paramString);
    setModifyTime(System.currentTimeMillis());
    this.a = "simple/page_all.rsp";
  }

  public String getExportStr()
  {
    ExportAction localExportAction = null;
    if (getModelStr().length() > 0)
      localExportAction = e.a().a(getModelStr()).c(getModelStr());
    else
      localExportAction = e.a().a(e()).b(e());
    if (localExportAction != null)
    {
      localExportAction.addModel("exportModel", this);
      return localExportAction.getText();
    }
    return "";
  }

  private String e()
  {
    String str = getImportFile();
    return str;
  }

  public String getPName()
  {
    if (getDisplayName().lastIndexOf("/") > 0)
      return getDisplayName().substring(0, getDisplayName().lastIndexOf("/"));
    return "";
  }

  public String getFName()
  {
    if (getDisplayName().lastIndexOf("/") > 0)
    {
      if (getDisplayName().lastIndexOf(".") > 0)
        return getDisplayName().substring(getDisplayName().lastIndexOf("/") + 1, getDisplayName().lastIndexOf("."));
      return getDisplayName().substring(getDisplayName().lastIndexOf("/") + 1);
    }
    if (getDisplayName().lastIndexOf(".") > 0)
      return getDisplayName().substring(0, getDisplayName().lastIndexOf("."));
    return getDisplayName();
  }

  public String getPropertyName()
  {
    if (getPName().length() == 0)
      return getFName();
    return getPName().replace('/', '.') + "." + getFName();
  }

  public List exportFile(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = getExportStr();
    File localFile = new File(paramString, getDisplayName());
    if (localFile.getParentFile() != null)
      localFile.getParentFile().mkdirs();
    if (localFile.exists())
      localFile.delete();
    JspUtil.saveHtmlFile(localFile.getPath(), str1);
    localArrayList.add(localFile);
    if (getModelStr().length() == 0)
    {
      String[] arrayOfString = getPreferences().getStringArray(getImportFile() + ".extends");
      if (arrayOfString != null)
        for (int i = 0; i < arrayOfString.length; i++)
        {
          String str2 = getPreferences().getString(arrayOfString[i] + ".export");
          if (str2 == null)
            continue;
          ExportAction localExportAction = e.a().a(arrayOfString[i]).b(arrayOfString[i]);
          if (localExportAction == null)
            continue;
          localExportAction.addModel("exportModel", this);
          String str3 = localExportAction.getText();
          str2 = StringUtil.replace("{pname}", getPName(), str2);
          str2 = StringUtil.replace("{fname}", getFName(), str2);
          str2 = StringUtil.replace("{local}", Locale.getDefault().toString(), str2);
          localFile = new File(paramString, str2);
          if (localFile.getParentFile() != null)
            localFile.getParentFile().mkdirs();
          if (localFile.exists())
            localFile.delete();
          JspUtil.saveHtmlFile(localFile.getPath(), str3);
          localArrayList.add(localFile);
        }
    }
    return localArrayList;
  }

  public d getDesignCompiler(String paramString)
  {
    return e.a().a(a(paramString));
  }

  public String getDesignStr(String paramString)
  {
    ExportAction localExportAction = null;
    localExportAction = e.a().a(a(paramString)).b(a(paramString));
    if (localExportAction != null)
    {
      localExportAction.addModel("exportModel", this);
      return localExportAction.getText();
    }
    return "";
  }

  public boolean exitsDesignFile(String paramString)
  {
    String str = a(paramString);
    if (str.length() > 0)
      return d.a(str);
    return false;
  }

  private String a(String paramString)
  {
    if (this.a.length() > 0)
    {
      if (this.a.indexOf("/") > 0)
        return this.a.substring(0, this.a.indexOf("/") + 1) + paramString + this.a.substring(this.a.indexOf("/") + 1);
      return paramString + this.a;
    }
    return "";
  }

  public d getExportCompiler()
  {
    if (getModelStr().length() > 0)
      return e.a().a(getModelStr());
    return e.a().a(e());
  }

  public String getIncludedStr()
  {
    if (getModelStr().length() > 0)
      return e.a().a(getModelStr()).l();
    return e.a().a(e()).l();
  }

  public String getSourceCode()
  {
    if (getModelStr().length() > 0)
      return e.a().a(getModelStr()).k();
    return e.a().a(e()).k();
  }

  public abstract PagesMessages getPreferences();

  public PageFieldModel addMappingVariable(MappingVariable paramMappingVariable)
  {
    PageFieldModel localPageFieldModel = (PageFieldModel)getPageField(paramMappingVariable.getVariableName());
    if (localPageFieldModel == null)
    {
      localPageFieldModel = new PageFieldModel();
      localPageFieldModel.update(paramMappingVariable, this);
      addChildElement(localPageFieldModel);
    }
    return localPageFieldModel;
  }

  public String getNextName(String paramString)
  {
    int i = 1;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof PageFieldModel)) || (!((PageFieldModel)localObject).getVariableName().startsWith(paramString)))
        continue;
      String str = NumberUtil.getNumberString(((PageFieldModel)localObject).getVariableName());
      if ((StringUtil.isEmpty(str)) || (NumberUtil.parseInt(str) <= i))
        continue;
      i = NumberUtil.parseInt(str) + 1;
    }
    return paramString + i;
  }

  public PageFieldModel addEmptyFieldModel()
  {
    PageFieldModel localPageFieldModel = new PageFieldModel();
    addChildElement(localPageFieldModel);
    localPageFieldModel.setVariableName(getNextName("field"));
    localPageFieldModel.setValueType("string");
    localPageFieldModel.setStatType("noput");
    return localPageFieldModel;
  }

  public IExportField getPageField(String paramString)
  {
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof PageFieldModel))
        continue;
      if (((PageFieldModel)localObject).getVariableName().equals(paramString))
        return (PageFieldModel)localObject;
      if (((PageFieldModel)localObject).getPageField(paramString) != null)
        return ((PageFieldModel)localObject).getPageField(paramString);
    }
    return null;
  }

  public List getPageFields()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof PageFieldModel))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public int getValueFieldCount(String paramString1, String paramString2)
  {
    int i = 0;
    Iterator localIterator = getAcceptElements(new a(this));
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof PageFieldModel))
        continue;
      if (paramString1.length() == 0)
      {
        i++;
      }
      else if (paramString2.equalsIgnoreCase("PageInOut"))
      {
        if (!((PageFieldModel)localObject).getStatType().equalsIgnoreCase(paramString1))
          continue;
        i++;
      }
      else if (paramString2.equalsIgnoreCase("PageInput"))
      {
        if (!((PageFieldModel)localObject).getInputType().equalsIgnoreCase(paramString1))
          continue;
        i++;
      }
      else if (paramString2.equalsIgnoreCase("PageOut"))
      {
        if (!((PageFieldModel)localObject).getResultType().equalsIgnoreCase(paramString1))
          continue;
        i++;
      }
      else if (paramString2.equalsIgnoreCase("varType"))
      {
        if (!((PageFieldModel)localObject).getValueType().equalsIgnoreCase(paramString1))
          continue;
        i++;
      }
      else if (paramString2.equalsIgnoreCase("InputType"))
      {
        if (!((PageFieldModel)localObject).getInputValueType().equalsIgnoreCase(paramString1))
          continue;
        i++;
      }
      else if (paramString2.equalsIgnoreCase("PageNull"))
      {
        if (!((PageFieldModel)localObject).getNullType().equalsIgnoreCase(paramString1))
          continue;
        i++;
      }
      else if (paramString2.equalsIgnoreCase("showValue"))
      {
        if (!((PageFieldModel)localObject).getShowValue().equalsIgnoreCase(paramString1))
          continue;
        i++;
      }
      else
      {
        if ((!paramString2.equalsIgnoreCase("valueFrom")) || (!((PageFieldModel)localObject).getValueFrom().equalsIgnoreCase(paramString1)))
          continue;
        i++;
      }
    }
    return i;
  }

  public int getInputFieldCount(String paramString)
  {
    int i = 0;
    Iterator localIterator = getAcceptElements(new b(this));
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof PageFieldModel)) || ((paramString.length() != 0) && (!((PageFieldModel)localObject).getInputType().equalsIgnoreCase(paramString))))
        continue;
      i++;
    }
    return i;
  }

  public int getOutFieldCount(String paramString)
  {
    int i = 0;
    Iterator localIterator = getAcceptElements(new c(this));
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((!(localObject instanceof PageFieldModel)) || ((paramString.length() != 0) && (!((PageFieldModel)localObject).getResultType().equalsIgnoreCase(paramString))))
        continue;
      i++;
    }
    return i;
  }

  public IExportField[] getPageFields(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((!(localObject instanceof PageFieldModel)) || ((paramString.length() != 0) && (!((PageFieldModel)localObject).getStatType().equalsIgnoreCase(paramString))))
        continue;
      localArrayList.add(localObject);
    }
    Object localObject = new PageFieldModel[localArrayList.size()];
    for (int i = 0; i < localArrayList.size(); i++)
      localObject[i] = ((PageFieldModel)localArrayList.get(i));
    return (IExportField)localObject;
  }

  public IExportField[] getValueFromFields(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString.split(",");
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof PageFieldModel))
        continue;
      for (i = 0; i < arrayOfString.length; i++)
      {
        if ((StringUtil.isEmpty(arrayOfString[i])) || (!((PageFieldModel)localObject).getValueFrom().equalsIgnoreCase(arrayOfString[i])))
          continue;
        localArrayList.add(localObject);
        break;
      }
    }
    Object localObject = new PageFieldModel[localArrayList.size()];
    for (int i = 0; i < localArrayList.size(); i++)
      localObject[i] = ((PageFieldModel)localArrayList.get(i));
    return (IExportField)localObject;
  }

  public IExportField[] getPropFields(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString2.split(",");
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof PageFieldModel))
        continue;
      for (i = 0; i < arrayOfString.length; i++)
      {
        if ((StringUtil.isEmpty(arrayOfString[i])) || (!((PageFieldModel)localObject).getPageTypeValue(paramString1).equalsIgnoreCase(arrayOfString[i])))
          continue;
        localArrayList.add(localObject);
        break;
      }
    }
    Object localObject = new PageFieldModel[localArrayList.size()];
    for (int i = 0; i < localArrayList.size(); i++)
      localObject[i] = ((PageFieldModel)localArrayList.get(i));
    return (IExportField)localObject;
  }

  public IExportField[] getAdditionalPropFields(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString2.split(",");
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof PageFieldModel))
        continue;
      for (i = 0; i < arrayOfString.length; i++)
      {
        if ((StringUtil.isEmpty(arrayOfString[i])) || (!((PageFieldModel)localObject).getPropertyValue(paramString1).equalsIgnoreCase(arrayOfString[i])))
          continue;
        localArrayList.add(localObject);
        break;
      }
    }
    Object localObject = new PageFieldModel[localArrayList.size()];
    for (int i = 0; i < localArrayList.size(); i++)
      localObject[i] = ((PageFieldModel)localArrayList.get(i));
    return (IExportField)localObject;
  }

  public String[] getDistinctFieldAdditionalProps(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof PageFieldModel))
        continue;
      String str = ((PageFieldModel)localObject).getPropertyValue(paramString);
      if ((StringUtil.isEmpty(str)) || (localHashMap.containsKey(str)))
        continue;
      localHashMap.put(str, str);
      localArrayList.add(str);
      break;
    }
    Object localObject = new String[localHashMap.size()];
    for (int i = 0; i < localHashMap.size(); i++)
      localObject[i] = ((String)localHashMap.get(Integer.valueOf(i)));
    return (String)localObject;
  }

  public String[] getDistinctElementAdditionalProps(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof PageElementModel))
        continue;
      String str = ((PageElementModel)localObject).getPropertyValue(paramString);
      if ((StringUtil.isEmpty(str)) || (localHashMap.containsKey(str)))
        continue;
      localHashMap.put(str, str);
      localArrayList.add(str);
      break;
    }
    Object localObject = new String[localHashMap.size()];
    for (int i = 0; i < localHashMap.size(); i++)
      localObject[i] = ((String)localHashMap.get(Integer.valueOf(i)));
    return (String)localObject;
  }

  public List getAllVars()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof PageFieldModel))
        continue;
      localArrayList.add(((PageFieldModel)localObject).getVariableName());
    }
    return localArrayList;
  }

  public IExportElement[] getPageElements()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof PageElementModel))
        continue;
      localArrayList.add(localObject);
    }
    Object localObject = new PageElementModel[localArrayList.size()];
    for (int i = 0; i < localArrayList.size(); i++)
      localObject[i] = ((PageElementModel)localArrayList.get(i));
    return (IExportElement)localObject;
  }

  public IExportElement[] getAdditionalPropElements(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = paramString2.split(",");
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof PageElementModel))
        continue;
      for (i = 0; i < arrayOfString.length; i++)
      {
        if ((StringUtil.isEmpty(arrayOfString[i])) || (!((PageElementModel)localObject).getPropertyValue(paramString1).equalsIgnoreCase(arrayOfString[i])))
          continue;
        localArrayList.add(localObject);
        break;
      }
    }
    Object localObject = new PageElementModel[localArrayList.size()];
    for (int i = 0; i < localArrayList.size(); i++)
      localObject[i] = ((PageElementModel)localArrayList.get(i));
    return (IExportElement)localObject;
  }

  public IExportField[] getPageFields(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if ((!(localObject instanceof PageFieldModel)) || ((!((PageFieldModel)localObject).getStatType().equalsIgnoreCase(paramString1)) && (!((PageFieldModel)localObject).getStatType().equalsIgnoreCase(paramString2))))
        continue;
      localArrayList.add(localObject);
    }
    Object localObject = new PageFieldModel[localArrayList.size()];
    for (int i = 0; i < localArrayList.size(); i++)
      localObject[i] = ((PageFieldModel)localArrayList.get(i));
    return (IExportField)localObject;
  }

  public String getExportFile()
  {
    return this.exportFile;
  }

  public String getModelStr()
  {
    return this.modelStr;
  }

  public void setExportFile(String paramString)
  {
    String str = paramString;
    if ((FileUtil.getCurrentDir().length() > 0) && (str.toLowerCase().startsWith(FileUtil.getCurrentDir().toLowerCase())))
      str = str.substring(FileUtil.getCurrentDir().length() + File.separator.length());
    this.exportFile = str;
  }

  public void setModelStr(String paramString)
  {
    this.modelStr = paramString;
  }

  public void setModified(boolean paramBoolean)
  {
    if (paramBoolean)
      setModifyTime(System.currentTimeMillis());
    super.setModified(paramBoolean);
  }

  public AdvancedProperty[] getAdvanceProperties()
  {
    AdvancedProperty[] arrayOfAdvancedProperty = new AdvancedProperty[getPropertiesList().size()];
    for (int i = 0; i < getPropertiesList().size(); i++)
      arrayOfAdvancedProperty[i] = ((AdvancedProperty)getPropertiesList().get(i));
    return arrayOfAdvancedProperty;
  }

  public String[] getKeysPre(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < getPropertiesList().size(); i++)
    {
      if ((paramString.length() != 0) && (!((AdvancedProperty)getPropertiesList().get(i)).getKey().toLowerCase().startsWith(paramString.toLowerCase())))
        continue;
      localArrayList.add(((AdvancedProperty)getPropertiesList().get(i)).getKey());
    }
    String[] arrayOfString = new String[localArrayList.size()];
    for (int j = 0; j < localArrayList.size(); j++)
      arrayOfString[j] = ((String)localArrayList.get(j));
    return arrayOfString;
  }

  public Iterator getProperties()
  {
    return getPropertiesList().iterator();
  }

  public String getRulePackageDisName()
  {
    if (getMainPackage() != null)
      return getMainPackage().getDisplayName();
    return "";
  }

  private RulePackage f()
  {
    IElement localIElement = getParent();
    if ((localIElement != null) && ((localIElement instanceof RulePackage)))
      return (RulePackage)localIElement;
    return null;
  }

  public String getExeRulePackageName()
  {
    if (f() != null)
      return f().getExeRulePackageName();
    return "";
  }

  public String getRulePackageVersion()
  {
    if (f() != null)
      return f().getMainVersion();
    return "";
  }

  public boolean paste(IElement paramIElement)
  {
    if ((((paramIElement instanceof PageFieldModel)) || ((paramIElement instanceof ElementContainer)) || ((paramIElement instanceof PageElementModel))) && (pasteElement((PageFieldModel)paramIElement, -1)))
    {
      updateViewer();
      return true;
    }
    return super.paste(paramIElement);
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if (((paramIElement != null) && ((paramIElement instanceof PageFieldModel))) || ((paramIElement instanceof PageElementModel)))
    {
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement(paramIElement, paramInt);
      else
        addChildElement(paramIElement);
      setModified(true);
      return true;
    }
    if ((paramIElement instanceof ElementContainer))
    {
      if (paramInt < 0)
        paramInt = getChildrenCount();
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((!(localObject instanceof PageFieldModel)) && (!(localObject instanceof PageElementModel)))
          continue;
        addChildElement((IElement)localObject, paramInt++);
      }
      setModified(true);
      return true;
    }
    return false;
  }

  public String getImportFile()
  {
    return this.a;
  }

  public void setImportFile(String paramString)
  {
    if (paramString.toLowerCase().startsWith(PagePropertyPool.getRSPDIR().toLowerCase()))
    {
      paramString = paramString.substring(PagePropertyPool.getRSPDIR().length() + File.separator.length());
      paramString = paramString.replace(File.separatorChar, '/');
    }
    this.a = paramString;
  }

  public boolean isRspFile()
  {
    return this.a.endsWith("rsp");
  }

  public boolean isJspFile()
  {
    return this.a.endsWith("jsp");
  }

  public String getTitle()
  {
    if (this.title.length() == 0)
      return getRulePackageDisName();
    return this.title;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }

  public boolean isEmptyProp(String paramString)
  {
    try
    {
      if (getPropertyValue(paramString).length() == 0)
        return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public boolean isPropValue(String paramString1, String paramString2)
  {
    return getPropertyValue(paramString1).equals(paramString2);
  }

  public boolean isPropValueNoCase(String paramString1, String paramString2)
  {
    return getPropertyValue(paramString1).equalsIgnoreCase(paramString2);
  }

  public boolean isVisible()
  {
    if ((getMainPackage() != null) && (getMainPackage().isPlugin()))
      return false;
    return super.isVisible();
  }

  protected String d()
  {
    String str = this.a;
    if (this.a != null)
    {
      if (str.lastIndexOf(".") > 0)
        str = str.substring(0, str.lastIndexOf("."));
      return str.replace('/', '.');
    }
    return str;
  }

  public boolean propInclude(String paramString1, String paramString2)
  {
    String[] arrayOfString = paramString2.split(",");
    for (int i = 0; i < arrayOfString.length; i++)
      if (paramString1.equalsIgnoreCase(arrayOfString[i]))
        return true;
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.AbstractPage
 * JD-Core Version:    0.6.0
 */
package com.flagleader.repository.db;

import com.flagleader.db.IKeyValue;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.sql.KeyValue;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;

public class SheetMap extends AbstractBOAndContainer
  implements IBOAndContainer
{
  private String englishName = null;
  private boolean fromResource = false;
  public static final String NAME = "SheetMap";
  public static final String DISPLAYNAME = getLocalString("SheetMap.text");
  private transient IKeyValue sheetData = null;
  private ArrayList values = null;
  private String keyType = "string";
  private String keyValueType = "string";
  private int implementType = 0;
  HSSFCellStyle a;
  private int inout = 0;

  public int getInout()
  {
    return this.inout;
  }

  public void setInout(int paramInt)
  {
    this.inout = paramInt;
  }

  public SheetMap(SheetMap paramSheetMap)
  {
    super(paramSheetMap);
    this.englishName = paramSheetMap.englishName;
    this.fromResource = paramSheetMap.fromResource;
  }

  public SheetMap()
  {
  }

  public SheetMap(String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    this.englishName = paramString3;
    updateFunction();
  }

  public String toString()
  {
    return getDisplayName();
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSheetMap(this);
  }

  public String getName()
  {
    return "SheetMap";
  }

  public List getResultFields()
  {
    ArrayList localArrayList = new ArrayList(0);
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof MapValue))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public void clearResultFields()
  {
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(getElement(i) instanceof MapValue))
        continue;
      removeElement(i);
    }
  }

  public IElement deepClone()
  {
    return new SheetMap(this);
  }

  public void changeDisplayName(String paramString)
  {
    for (int i = 0; i < a().size(); i++)
    {
      IElement localIElement = (IElement)a().get(i);
      if (localIElement.getDisplayName().indexOf(getDisplayName()) < 0)
        continue;
      localIElement.setDisplayName(StringUtil.replace(getDisplayName(), paramString, localIElement.getDisplayName()));
    }
    setDisplayName(paramString);
    setModified(true);
  }

  public void changeVarName(String paramString)
  {
    setEnglishName(paramString);
  }

  public void updateFunction()
  {
    if (getTableFunction("getString") == null)
    {
      addChildElement(new TableFunction("getString", "string", "getString({arg1})", format("getString.map", new Object[] { getDisplayName(), "{arg1}" }), a("string"), true, getLocalString("getString.mapgroup")));
    }
    else
    {
      getTableFunction("getString").setDisplayName(format("getString.map", new Object[] { getDisplayName(), "{arg1}" }));
      getTableFunction("getString").setGroupName(getLocalString("getString.mapgroup"));
    }
    if (getTableFunction("setString") == null)
    {
      addChildElement(new TableFunction("setString", "void", "setString({arg1},{arg2})", format("setString.map", new Object[] { getDisplayName(), "{arg1}", "{arg2}" }), a(new String[] { "string", "string" }), true, getLocalString("setString.mapgroup")));
    }
    else
    {
      getTableFunction("setString").setDisplayName(format("setString.map", new Object[] { getDisplayName(), "{arg1}", "{arg2}" }));
      getTableFunction("setString").setGroupName(getLocalString("setString.mapgroup"));
    }
    if (getTableFunction("loadFromView") == null)
    {
      addChildElement(new TableFunction("loadFromView", "void", "loadFromView({arg1})", format("loadFromView.map", new Object[] { "{arg1}", getDisplayName() }), a("com.flagleader.db.IResult"), false, getLocalString("loadFromView.mapgroup")));
    }
    else
    {
      getTableFunction("loadFromView").setDisplayName(format("loadFromView.map", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("loadFromView").setGroupName(getLocalString("loadFromView.mapgroup"));
    }
    if (getTableFunction("updateBySheet") == null)
    {
      addChildElement(new TableFunction("updateBySheet", "void", "updateBySheet({arg1},{arg2},{arg3})", format("updateBySheet.map", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }), a(new String[] { "com.flagleader.db.Sheet", "string", "string" }), false, getLocalString("updateBySheet.mapgroup")));
    }
    else
    {
      getTableFunction("updateBySheet").setDisplayName(format("updateBySheet.map", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }));
      getTableFunction("updateBySheet").setGroupName(getLocalString("updateBySheet.mapgroup"));
    }
    if (getTableFunction("updateByResult") == null)
    {
      addChildElement(new TableFunction("updateByResult", "void", "updateByResult({arg1},{arg2},{arg3})", format("updateByResult.map", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }), a(new String[] { "com.flagleader.db.IResult", "string", "string" }), false, getLocalString("updateByResult.mapgroup")));
    }
    else
    {
      getTableFunction("updateByResult").setDisplayName(format("updateByResult.map", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }));
      getTableFunction("updateByResult").setGroupName(getLocalString("updateByResult.mapgroup"));
    }
    if (getTableFunction("loadFromSheet") == null)
    {
      addChildElement(new TableFunction("loadFromSheet", "void", "loadFromSheet({arg1})", format("loadFromSheet.map", new Object[] { "{arg1}", getDisplayName() }), a("com.flagleader.db.Sheet"), false, getLocalString("loadFromSheet.mapgroup")));
    }
    else
    {
      getTableFunction("loadFromSheet").setDisplayName(format("loadFromSheet.map", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("loadFromSheet").setGroupName(getLocalString("loadFromSheet.mapgroup"));
    }
    if (getTableFunction("getListResult") == null)
    {
      addChildElement(new TableFunction("getListResult", "list<list>", "getListResult()", format("getListResult.map", new Object[] { getDisplayName() }), null, getLocalString("getListResult.mapgroup")));
    }
    else
    {
      getTableFunction("getListResult").setDisplayName(format("getListResult.map", new Object[] { getDisplayName() }));
      getTableFunction("getListResult").setGroupName(getLocalString("getListResult.mapgroup"));
    }
    if (getTableFunction("loadFromList") == null)
    {
      addChildElement(new TableFunction("loadFromList", "void", "loadFromList({arg1})", format("loadFromList.map", new Object[] { "{arg1}", getDisplayName() }), a("list<list>"), false, getLocalString("loadFromList.mapgroup")));
    }
    else
    {
      getTableFunction("loadFromList").setDisplayName(format("loadFromList.map", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("loadFromList").setGroupName(getLocalString("loadFromList.mapgroup"));
    }
    if (getTableFunction("getRows") == null)
    {
      addChildElement(new TableFunction("getRows", "int", "getRows()", format("getRows.map", new Object[] { getDisplayName() }), null, getLocalString("getRows.mapgroup")));
    }
    else
    {
      getTableFunction("getRows").setDisplayName(format("getRows.map", new Object[] { getDisplayName() }));
      getTableFunction("getRows").setGroupName(getLocalString("getRows.mapgroup"));
    }
    if (getTableFunction("resetValues") == null)
    {
      addChildElement(new TableFunction("resetValues", "void", "resetValues()", format("resetValues.map", new Object[] { getDisplayName() }), null, getLocalString("resetValues.mapgroup")));
    }
    else
    {
      getTableFunction("resetValues").setDisplayName(format("resetValues.map", new Object[] { getDisplayName() }));
      getTableFunction("resetValues").setGroupName(getLocalString("resetValues.mapgroup"));
    }
  }

  public String getEnglishName()
  {
    if ((this.englishName == null) || (this.englishName.length() == 0))
      return getDisplayName();
    return this.englishName;
  }

  public void setEnglishName(String paramString)
  {
    this.englishName = paramString;
  }

  public String getVarValue()
  {
    if (StringUtil.isJavaIdentifier(getEnglishName()))
      return getEnglishName();
    if ((getParent() != null) && (getParent().getParent() != null))
      return "map" + getParent().getParent().getElementPos(getParent()) + "_" + getParent().getElementPos(this);
    return getEnglishName();
  }

  public String getValueName()
  {
    return getEnglishName();
  }

  public String getValueType()
  {
    return "com.flagleader.db.IKeyValue";
  }

  public MapValue getField(String paramString)
  {
    List localList = getFields();
    for (int i = 0; i < localList.size(); i++)
    {
      MapValue localMapValue = (MapValue)localList.get(i);
      if (localMapValue.getKey().equalsIgnoreCase(paramString))
        return localMapValue;
    }
    return null;
  }

  public boolean exitsFields(Object paramObject)
  {
    if (!(paramObject instanceof MapValue))
      return false;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof MapValue)) && (((MapValue)localObject).getKey().equals(((MapValue)paramObject).getKey())) && (((MapValue)localObject).getValue().equals(((MapValue)paramObject).getValue())))
        return true;
    }
    return false;
  }

  public MapValue getFieldByDisplay(String paramString)
  {
    List localList = getFields();
    for (int i = 0; i < localList.size(); i++)
    {
      MapValue localMapValue = (MapValue)localList.get(i);
      if (localMapValue.getValue().equalsIgnoreCase(paramString))
        return localMapValue;
    }
    return null;
  }

  public void updateDisplayNames()
  {
    changeDisplayName(getDisplayName());
    setModified(true);
  }

  public Iterator getFieldIterator()
  {
    return getAcceptChildren(new a(this));
  }

  public List getFields()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof MapValue))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public List getFieldValueList()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if ((!(a().get(i) instanceof MapValue)) || (StringUtil.isEmpty(((MapValue)a().get(i)).getValue())))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public String[] getFieldNames()
  {
    List localList = getFields();
    String[] arrayOfString = new String[localList.size()];
    for (int i = 0; i < localList.size(); i++)
      arrayOfString[i] = ((MapValue)localList.get(i)).getKey();
    return arrayOfString;
  }

  public List getFieldNameList()
  {
    List localList = getFields();
    ArrayList localArrayList = new ArrayList(localList.size());
    for (int i = 0; i < localList.size(); i++)
      localArrayList.add(((MapValue)localList.get(i)).getKey());
    return localArrayList;
  }

  public String[] getFieldDisNames()
  {
    List localList = getFields();
    String[] arrayOfString = new String[localList.size()];
    for (int i = 0; i < localList.size(); i++)
      arrayOfString[i] = ((MapValue)localList.get(i)).getValue();
    return arrayOfString;
  }

  protected List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new MethodParam(paramString, 0));
    return localArrayList;
  }

  protected List a(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfString.length);
    for (int i = 0; i < paramArrayOfString.length; i++)
      localArrayList.add(new MethodParam(paramArrayOfString[i], i));
    return localArrayList;
  }

  public TableFunction getTableFunction(String paramString)
  {
    List localList = e();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof TableFunction)) && (((TableFunction)localList.get(i)).getValueName().equals(paramString)))
        return (TableFunction)localList.get(i);
    return null;
  }

  public Iterator getEditens()
  {
    return e().iterator();
  }

  protected List e()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof IBusinessObjectEditen))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public IBusinessObjectContainer getContainer()
  {
    return this;
  }

  public boolean isEditVisible()
  {
    return true;
  }

  private String a(int paramInt)
  {
    int i = paramInt / 26;
    int j = paramInt % 26;
    if (i > 0)
      return String.valueOf(b(i - 1)) + String.valueOf(b(j));
    return String.valueOf(b(j));
  }

  private char b(int paramInt)
  {
    return (char)(65 + paramInt);
  }

  public IKeyValue getSheetData()
  {
    if ((this.sheetData == null) && (a().size() > 0))
    {
      KeyValue localKeyValue = new KeyValue(getDisplayName(), getKeyType(), getKeyValueType());
      for (int i = 0; i < a().size(); i++)
      {
        if (!(a().get(i) instanceof MapValue))
          continue;
        localKeyValue.append(((MapValue)a().get(i)).getKey(), ((MapValue)a().get(i)).getValue());
      }
      this.sheetData = localKeyValue;
    }
    return this.sheetData;
  }

  public void setSheetData(IKeyValue paramIKeyValue)
  {
    if (this.sheetData != null)
      this.sheetData.resetValues();
    this.sheetData = paramIKeyValue;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof MapValue))
    {
      initUndoable();
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement(paramIElement, paramInt);
      else
        addChildElement(paramIElement);
      takeSnapshot();
      setModified(true);
      return true;
    }
    Object localObject1;
    if ((paramIElement instanceof IVariableObject))
    {
      IVariableObject localIVariableObject1 = (IVariableObject)paramIElement;
      initUndoable();
      localObject1 = new MapValue();
      ((MapValue)localObject1).setKey(localIVariableObject1.getValueName());
      ((MapValue)localObject1).setValue(localIVariableObject1.getDisplayName());
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement((IElement)localObject1);
      else
        addChildElement((IElement)localObject1);
      takeSnapshot();
      setModified(true);
      return true;
    }
    if ((paramIElement instanceof ElementContainer))
    {
      if (paramInt < 0)
        paramInt = getChildrenCount();
      initUndoable();
      int i = 0;
      localObject1 = ((ElementContainer)paramIElement).getChildrenIterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof MapValue))
        {
          addChildElement((MapValue)localObject2);
          i = 1;
        }
        else
        {
          if (!(localObject2 instanceof IVariableObject))
            continue;
          IVariableObject localIVariableObject2 = (IVariableObject)localObject2;
          initUndoable();
          MapValue localMapValue = new MapValue();
          localMapValue.setKey(localIVariableObject2.getValueName());
          localMapValue.setValue(localIVariableObject2.getDisplayName());
          addChildElement(localMapValue);
          i = 1;
        }
      }
      if (i != 0)
      {
        takeSnapshot();
        setModified(true);
      }
      return true;
    }
    return false;
  }

  public boolean isDBSheet()
  {
    return getParent() instanceof DBModel;
  }

  public List getSheetValues()
  {
    return getFields();
  }

  public void removeSheetValue(MapValue paramMapValue)
  {
    removeChildElement(paramMapValue);
  }

  public void addSheetValue(String paramString1, String paramString2)
  {
    addChildElement(new MapValue(paramString1, paramString2));
  }

  public void addSheetValue(MapValue paramMapValue)
  {
    addChildElement(paramMapValue);
  }

  public void replaceVariables(List paramList1, List paramList2, List paramList3, List paramList4)
  {
    for (int i = getChildrenCount() - 1; i >= 0; i--)
    {
      if (!(getElement(i) instanceof MapValue))
        continue;
      removeElement(i);
    }
    for (i = 0; i < paramList1.size(); i++)
    {
      MapValue localMapValue = new MapValue();
      localMapValue.setKey(String.valueOf(paramList1.get(i)));
      localMapValue.setValue(String.valueOf(paramList3.get(i)));
      addChildElement(localMapValue);
    }
    setModified(true);
    updateViewer();
  }

  public String getKeyType()
  {
    return this.keyType;
  }

  public void setKeyType(String paramString)
  {
    this.keyType = paramString;
  }

  public String getKeyValueType()
  {
    return this.keyValueType;
  }

  public void setKeyValueType(String paramString)
  {
    this.keyValueType = paramString;
  }

  public boolean canCreateEditen()
  {
    return true;
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    MapValue localMapValue = new MapValue();
    localMapValue.setKey(paramString);
    localMapValue.setValueType("string");
    addChildElement(localMapValue);
    setModified(true);
    return localMapValue;
  }

  public boolean isFromResource()
  {
    return this.fromResource;
  }

  public void setFromResource(boolean paramBoolean)
  {
    this.fromResource = paramBoolean;
  }

  public int getImplementType()
  {
    return this.implementType;
  }

  public void setImplementType(int paramInt)
  {
    this.implementType = paramInt;
  }

  public boolean needInit()
  {
    return (getFieldValueList().size() > 0) || (isFromResource());
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.SheetMap
 * JD-Core Version:    0.6.0
 */
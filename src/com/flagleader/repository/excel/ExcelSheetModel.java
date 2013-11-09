package com.flagleader.repository.excel;

import com.flagleader.excel.FieldInfo;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.u;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.List;

public class ExcelSheetModel extends AbstractExcelObject
  implements IExcelObject
{
  private String sheetName = "";
  private String sheetReg = "";
  private String modelName = "";
  private boolean showBorder = true;
  private boolean mergeValue = false;
  public static final String NAME = "ExcelSheetModel";
  public static final String DISPLAYNAME = getLocalString("ExcelSheetModel.text");
  public static String[] COLORNAMES = { "", "RED", "BLUE", "YELLOW", "GREEN", "GREY_25_PERCENT", "LIGHT_TURQUOISE", "LEMON_CHIFFON", "AQUA", "BRIGHT_GREEN", "TURQUOISE", "LAVENDER", "LIGHT_BLUE", "DARK_YELLOW.index", "LIGHT_ORANGE", "DARK_YELLOW", "LIGHT_ORANGE", "LIME", "VIOLET", "GOLD", "BROWN", "ROSE", "LIGHT_TURQUOISE", "BLUE_GREY", "TEAL", "BRIGHT_GREEN2", "CORNFLOWER_BLUE", "DARK_BLUE", "INDIGO", "DARK_RED", "PLUM", "PALE_BLUE", "LEMON_CHIFFON", "MAROON", "ORCHID", "CORAL", "ROYAL_BLUE", "LIGHT_CORNFLOWER_BLUE", "LIGHT_GREEN", "LIGHT_YELLOW", "GREY_50_PERCENT", "PINK", "WHITE", "BLACK" };
  public static String[] COLORTYPES = new String[COLORNAMES.length];

  static
  {
    COLORTYPES[0] = "";
    for (int i = 1; i < COLORTYPES.length; i++)
      COLORTYPES[i] = u.a(COLORNAMES[i] + ".COLOR");
  }

  public ExcelSheetModel(ExcelSheetModel paramExcelSheetModel)
  {
    super(paramExcelSheetModel);
    this.sheetName = paramExcelSheetModel.sheetName;
    this.sheetReg = paramExcelSheetModel.sheetReg;
    this.showBorder = paramExcelSheetModel.showBorder;
    this.mergeValue = paramExcelSheetModel.mergeValue;
  }

  public ExcelSheetModel()
  {
  }

  public ExcelSheetModel(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.sheetName = paramString2;
    this.sheetReg = paramString3;
    updateFunction();
  }

  public void updateFunction()
  {
    if (getExcelFunction("beforeFirstSheet") == null)
    {
      addChildElement(new ExcelFunction("beforeFirstSheet", "void", "beforeFirstSheet()", format("beforeFirstSheet.excel", new Object[] { getDisplayName() }), null, true, getLocalString("beforeFirstSheet.excelgroup")));
    }
    else
    {
      getExcelFunction("beforeFirstSheet").setDisplayName(format("beforeFirstSheet.excel", new Object[] { getDisplayName() }));
      getExcelFunction("beforeFirstSheet").setGroupName(getLocalString("beforeFirstSheet.excelgroup"));
    }
    if (getExcelFunction("getNextSheet") == null)
    {
      addChildElement(new ExcelFunction("getNextSheet", "boolean", "getNextSheet()", format("getNextSheet.excel", new Object[] { getDisplayName() }), null, true, getLocalString("getNextSheet.excelgroup")));
    }
    else
    {
      getExcelFunction("getNextSheet").setDisplayName(format("getNextSheet.excel", new Object[] { getDisplayName() }));
      getExcelFunction("getNextSheet").setGroupName(getLocalString("getNextSheet.excelgroup"));
    }
    if (getExcelFunction("createSheet") == null)
    {
      addChildElement(new ExcelFunction("createSheet", "boolean", "createSheet({arg1})", format("createSheet.excel", new Object[] { "{arg1}", getDisplayName() }), a("string"), true, getLocalString("createSheet.excelgroup")));
    }
    else
    {
      getExcelFunction("createSheet").setDisplayName(format("createSheet.excel", new Object[] { "{arg1}", getDisplayName() }));
      getExcelFunction("createSheet").setGroupName(getLocalString("createSheet.excelgroup"));
    }
    if (getExcelFunction("getSheetName") == null)
    {
      addChildElement(new ExcelFunction("getSheetName", "string", "getSheetName()", format("getSheetName.excel", new Object[] { getDisplayName() }), null, true, getLocalString("getSheetName.excelgroup")));
    }
    else
    {
      getExcelFunction("getSheetName").setDisplayName(format("getSheetName.excel", new Object[] { getDisplayName() }));
      getExcelFunction("getSheetName").setGroupName(getLocalString("getSheetName.excelgroup"));
    }
    if (getExcelFunction("mergeCell") == null)
    {
      addChildElement(new ExcelFunction("mergeCell", "void", "mergeCell({arg1},{arg2},{arg3},{arg4})", format("mergeCell.excel", new Object[] { getDisplayName(), "{arg1}", "{arg2}", "{arg3}", "{arg4}" }), a(new String[] { "short", "int", "short", "int" }), true, getLocalString("mergeCell.excelgroup")));
    }
    else
    {
      getExcelFunction("mergeCell").setDisplayName(format("mergeCell.excel", new Object[] { getDisplayName(), "{arg1}", "{arg2}", "{arg3}", "{arg4}" }));
      getExcelFunction("mergeCell").setGroupName(getLocalString("mergeCell.excelgroup"));
    }
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
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  public boolean canCreateEditen()
  {
    return true;
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    ExcelRowModel localExcelRowModel = new ExcelRowModel();
    localExcelRowModel.setFieldPos(NumberUtil.parseInt(paramString));
    localExcelRowModel.setValueType("string");
    localExcelRowModel.setDisplayName(paramString);
    localExcelRowModel.setVisible(true);
    addChildElement(localExcelRowModel);
    setModified(true);
    return localExcelRowModel;
  }

  public ExcelBookModel getExcelBookModel()
  {
    return (ExcelBookModel)getParent();
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    return false;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitExcelSheetModel(this);
  }

  public IElement deepClone()
  {
    return new ExcelSheetModel(this);
  }

  public String getName()
  {
    return "ExcelSheetModel";
  }

  public String getValueType()
  {
    return "com.flagleader.excel.IExcelSheet";
  }

  public String getVarValue()
  {
    return getSheetName();
  }

  public String getValueName()
  {
    return getSheetName();
  }

  public String getSheetName()
  {
    if ((getParent() != null) && ((getParent() instanceof ExcelBookModel)))
      return ((ExcelBookModel)getParent()).getVarValue() + "_" + ((ExcelBookModel)getParent()).getChildrenList().indexOf(this);
    if (getParent() != null)
      return "sheet" + getParent().getElementPos(this);
    return getDisplayName();
  }

  public void setSheetName(String paramString)
  {
  }

  public String getSheetReg()
  {
    return this.sheetReg;
  }

  public void setSheetReg(String paramString)
  {
    this.sheetReg = paramString;
  }

  protected FieldInfo[] a(AbstractExcelFieldModel paramAbstractExcelFieldModel)
  {
    List localList = paramAbstractExcelFieldModel.getTypeSuperChildrenList(AbstractExcelFieldModel.class);
    FieldInfo[] arrayOfFieldInfo = new FieldInfo[localList.size()];
    for (int i = 0; i < localList.size(); i++)
      arrayOfFieldInfo[i] = b((AbstractExcelFieldModel)localList.get(i));
    return arrayOfFieldInfo;
  }

  protected FieldInfo b(AbstractExcelFieldModel paramAbstractExcelFieldModel)
  {
    FieldInfo[] arrayOfFieldInfo = (FieldInfo[])null;
    if (paramAbstractExcelFieldModel.hasChildField())
      arrayOfFieldInfo = a(paramAbstractExcelFieldModel);
    FieldInfo localFieldInfo = new FieldInfo(paramAbstractExcelFieldModel.getDisplayName(), paramAbstractExcelFieldModel.getValueType(), paramAbstractExcelFieldModel.getFieldPos(), paramAbstractExcelFieldModel.getAmountType(), arrayOfFieldInfo);
    return localFieldInfo;
  }

  public String getModelName()
  {
    return this.modelName;
  }

  public void setModelName(String paramString)
  {
    this.modelName = paramString;
  }

  public boolean isShowBorder()
  {
    return this.showBorder;
  }

  public void setShowBorder(boolean paramBoolean)
  {
    this.showBorder = paramBoolean;
  }

  public boolean isMergeValue()
  {
    return this.mergeValue;
  }

  public void setMergeValue(boolean paramBoolean)
  {
    this.mergeValue = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.ExcelSheetModel
 * JD-Core Version:    0.6.0
 */
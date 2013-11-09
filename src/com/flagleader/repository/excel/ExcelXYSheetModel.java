package com.flagleader.repository.excel;

import com.flagleader.excel.ExcelFactory;
import com.flagleader.excel.FieldInfo;
import com.flagleader.excel.IExcelXYSheet;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.util.NumberUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelXYSheetModel extends ExcelSheetModel
  implements IBusinessObjectContainer
{
  public static final String NAME = "ExcelXYSheetModel";
  public static final String DISPLAYNAME = getLocalString("ExcelXYSheetModel.text");
  private int colNameLine = 1;
  private int startRowLine = 2;
  private short rowNameLine = 1;
  private short startCol = 2;
  private int colAmountLine = 0;
  private short rowAmountLine = 1;
  private String rowType = "string";
  private String colType = "string";
  private String cellType = "double";
  private int changedType = 0;
  private int emptycol = 1;
  private IExcelXYSheet sheetData = null;
  private long datatime = 0L;
  private long getAllRuleElementTime = 0L;
  private ArrayList allRules = null;

  public ExcelXYSheetModel(ExcelXYSheetModel paramExcelXYSheetModel)
  {
    super(paramExcelXYSheetModel);
    this.colAmountLine = paramExcelXYSheetModel.colAmountLine;
    this.startCol = paramExcelXYSheetModel.startCol;
    this.startRowLine = paramExcelXYSheetModel.startRowLine;
    this.rowNameLine = paramExcelXYSheetModel.rowNameLine;
    this.rowAmountLine = paramExcelXYSheetModel.rowAmountLine;
    this.colNameLine = paramExcelXYSheetModel.colNameLine;
    this.rowType = paramExcelXYSheetModel.rowType;
    this.colType = paramExcelXYSheetModel.colType;
    this.cellType = paramExcelXYSheetModel.cellType;
    this.changedType = paramExcelXYSheetModel.changedType;
    this.emptycol = paramExcelXYSheetModel.emptycol;
  }

  public ExcelXYSheetModel(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, short paramShort)
  {
    super(paramString1, paramString2, paramString3);
    this.colNameLine = paramInt1;
    this.startRowLine = paramInt2;
    this.startCol = paramShort;
    createRowModel("0", "string", "Y");
    createColModel("0", "string", "X");
    createCellModel("0", "double", "value");
  }

  public ExcelXYSheetModel()
  {
  }

  public void updateFunction()
  {
    super.updateFunction();
    if (getExcelFunction("beforeFirstCell") == null)
    {
      addChildElement(new ExcelFunction("beforeFirstCell", "void", "beforeFirstCell()", format("beforeFirstCell.excel", new Object[] { getDisplayName() }), null, true, getLocalString("beforeFirstCell.excelgroup")));
    }
    else
    {
      getExcelFunction("beforeFirstCell").setDisplayName(format("beforeFirstCell.excel", new Object[] { getDisplayName() }));
      getExcelFunction("beforeFirstCell").setGroupName(getLocalString("beforeFirstCell.excelgroup"));
    }
    if (getExcelFunction("nextCell") == null)
    {
      addChildElement(new ExcelFunction("nextCell", "boolean", "nextCell()", format("nextCell.excel", new Object[] { getDisplayName() }), null, true, getLocalString("nextCell.excelgroup")));
    }
    else
    {
      getExcelFunction("nextCell").setDisplayName(format("nextCell.excel", new Object[] { getDisplayName() }));
      getExcelFunction("nextCell").setGroupName(getLocalString("nextCell.excelgroup"));
    }
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitExcelXYSheetModel(this);
  }

  public IElement deepClone()
  {
    return new ExcelXYSheetModel(this);
  }

  public String getName()
  {
    return "ExcelXYSheetModel";
  }

  public boolean canCreateEditen()
  {
    return super.canCreateEditen();
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    return super.createSubEditen(paramString);
  }

  public List getAllFields()
  {
    if ((this.getAllRuleElementTime == getMaxModifyTime()) && (this.allRules != null))
      return this.allRules;
    this.allRules = new ArrayList();
    this.allRules.addAll(getTypeSuperChildrenList(ExcelRowModel.class));
    this.allRules.addAll(getTypeSuperChildrenList(ExcelColModel.class));
    this.allRules.addAll(getTypeSuperChildrenList(ExcelCellModel.class));
    this.getAllRuleElementTime = getMaxModifyTime();
    return this.allRules;
  }

  public IExcelXYSheet getSheetData()
  {
    if ((this.sheetData == null) || (getExcelBookModel().getMaxModifyTime() > this.datatime))
    {
      this.datatime = getExcelBookModel().getMaxModifyTime();
      getExcelBookModel().setExcelData(null);
      List localList1 = getTypeSuperChildrenList(ExcelRowModel.class);
      FieldInfo[] arrayOfFieldInfo1 = new FieldInfo[localList1.size()];
      for (int i = 0; i < localList1.size(); i++)
        arrayOfFieldInfo1[i] = b((ExcelRowModel)localList1.get(i));
      List localList2 = getTypeSuperChildrenList(ExcelColModel.class);
      FieldInfo[] arrayOfFieldInfo2 = new FieldInfo[localList2.size()];
      for (int j = 0; j < localList2.size(); j++)
        arrayOfFieldInfo2[j] = b((ExcelColModel)localList2.get(j));
      List localList3 = getTypeSuperChildrenList(ExcelCellModel.class);
      FieldInfo[] arrayOfFieldInfo3 = new FieldInfo[localList3.size()];
      for (int k = 0; k < localList3.size(); k++)
        arrayOfFieldInfo3[k] = b((ExcelCellModel)localList3.get(k));
      IExcelXYSheet localIExcelXYSheet = ExcelFactory.newIntance().createXYSheet(getExcelBookModel().getExcelData(), getDisplayName(), getSheetReg(), arrayOfFieldInfo1, arrayOfFieldInfo2, arrayOfFieldInfo3, getColNameLine() - 1, this.startRowLine - 1, this.startCol - 1, getRowNameLine() - 1, getRowAmountLine());
      localIExcelXYSheet.setEmptycol(getEmptycol());
      localIExcelXYSheet.setChangedType(getChangedType());
      localIExcelXYSheet.setShowBorder(isShowBorder());
      localIExcelXYSheet.setMergeValue(isMergeValue());
      this.sheetData = localIExcelXYSheet;
      this.sheetData.beforeFirstSheet();
      this.sheetData.getNextSheet();
    }
    return this.sheetData;
  }

  public List getColModels()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof ExcelColModel))
        continue;
      localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public ExcelRowModel createRowModel(String paramString1, String paramString2, String paramString3)
  {
    ExcelRowModel localExcelRowModel = new ExcelRowModel();
    localExcelRowModel.setFieldPos(NumberUtil.parseInt(paramString1));
    localExcelRowModel.setValueType(paramString2);
    localExcelRowModel.setDisplayName(paramString3);
    localExcelRowModel.setVisible(true);
    addChildElement(localExcelRowModel);
    return localExcelRowModel;
  }

  public ExcelColModel createColModel(String paramString1, String paramString2, String paramString3)
  {
    ExcelColModel localExcelColModel = new ExcelColModel();
    localExcelColModel.setFieldPos(NumberUtil.parseInt(paramString1));
    localExcelColModel.setValueType(paramString2);
    localExcelColModel.setDisplayName(paramString3);
    localExcelColModel.setVisible(true);
    addChildElement(localExcelColModel);
    return localExcelColModel;
  }

  public ExcelCellModel createCellModel(String paramString1, String paramString2, String paramString3)
  {
    ExcelCellModel localExcelCellModel = new ExcelCellModel();
    localExcelCellModel.setFieldPos(NumberUtil.parseInt(paramString1));
    localExcelCellModel.setValueType(paramString2);
    localExcelCellModel.setDisplayName(paramString3);
    localExcelCellModel.setVisible(true);
    addChildElement(localExcelCellModel);
    return localExcelCellModel;
  }

  public String getValueType()
  {
    return "com.flagleader.excel.IExcelXYSheet";
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof AbstractExcelFieldModel))
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
    if ((paramIElement instanceof ElementContainer))
    {
      if (paramInt < 0)
        paramInt = getChildrenCount();
      initUndoable();
      int i = 0;
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (!(localObject instanceof AbstractExcelFieldModel))
          continue;
        addChildElement((AbstractExcelFieldModel)localObject, paramInt++);
        i = 1;
      }
      if (i != 0)
      {
        takeSnapshot();
        setModified(true);
      }
      return true;
    }
    return super.pasteElement(paramIElement, paramInt);
  }

  public String getVarValue()
  {
    return super.getVarValue();
  }

  public int getColNameLine()
  {
    return this.colNameLine;
  }

  public void setColNameLine(int paramInt)
  {
    this.colNameLine = paramInt;
  }

  public int getStartRowLine()
  {
    return this.startRowLine;
  }

  public void setStartRowLine(int paramInt)
  {
    this.startRowLine = paramInt;
  }

  public short getRowNameLine()
  {
    return this.rowNameLine;
  }

  public void setRowNameLine(short paramShort)
  {
    this.rowNameLine = paramShort;
  }

  public short getStartCol()
  {
    return this.startCol;
  }

  public void setStartCol(short paramShort)
  {
    this.startCol = paramShort;
  }

  public int getColAmountLine()
  {
    return this.colAmountLine;
  }

  public void setColAmountLine(int paramInt)
  {
    this.colAmountLine = paramInt;
  }

  public short getRowAmountLine()
  {
    return this.rowAmountLine;
  }

  public void setRowAmountLine(short paramShort)
  {
    this.rowAmountLine = paramShort;
  }

  public String getRowType()
  {
    return this.rowType;
  }

  public void setRowType(String paramString)
  {
    this.rowType = paramString;
  }

  public String getColType()
  {
    return this.colType;
  }

  public void setColType(String paramString)
  {
    this.colType = paramString;
  }

  public String getCellType()
  {
    return this.cellType;
  }

  public void setCellType(String paramString)
  {
    this.cellType = paramString;
  }

  public int getChangedType()
  {
    return this.changedType;
  }

  public void setChangedType(int paramInt)
  {
    this.changedType = paramInt;
  }

  public int getEmptycol()
  {
    return this.emptycol;
  }

  public void setEmptycol(int paramInt)
  {
    this.emptycol = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.ExcelXYSheetModel
 * JD-Core Version:    0.6.0
 */
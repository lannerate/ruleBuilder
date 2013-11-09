package com.flagleader.repository.excel;

import com.flagleader.excel.ExcelFactory;
import com.flagleader.excel.FieldInfo;
import com.flagleader.excel.IExcelTableSheet;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelTableSheetModel extends ExcelSheetModel
  implements IBusinessObjectContainer
{
  public static final String NAME = "ExcelTableSheetModel";
  public static final String DISPLAYNAME = getLocalString("ExcelTableSheetModel.text");
  private int colNameLine = 1;
  private int startRowLine = 2;
  private short startCol = 1;
  private short rowAmountLine = 1;
  private int acceptEmpty = 0;
  private IExcelTableSheet sheetData = null;
  private long datatime = 0L;
  private boolean mergeSame = false;

  public ExcelTableSheetModel()
  {
  }

  public ExcelTableSheetModel(ExcelTableSheetModel paramExcelTableSheetModel)
  {
    super(paramExcelTableSheetModel);
    this.colNameLine = paramExcelTableSheetModel.colNameLine;
    this.startRowLine = paramExcelTableSheetModel.startRowLine;
    this.startCol = paramExcelTableSheetModel.startCol;
    this.rowAmountLine = paramExcelTableSheetModel.rowAmountLine;
    this.acceptEmpty = paramExcelTableSheetModel.acceptEmpty;
    this.mergeSame = paramExcelTableSheetModel.mergeSame;
  }

  public ExcelTableSheetModel(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, short paramShort)
  {
    super(paramString1, paramString2, paramString3);
    this.colNameLine = paramInt1;
    this.startRowLine = paramInt2;
    this.startCol = paramShort;
  }

  public void updateFunction()
  {
    super.updateFunction();
    if (getExcelFunction("beforeFirstRow") == null)
    {
      addChildElement(new ExcelFunction("beforeFirstRow", "void", "beforeFirstRow()", format("beforeFirstRow.excel", new Object[] { getDisplayName() }), null, true, getLocalString("beforeFirstRow.excelgroup")));
    }
    else
    {
      getExcelFunction("beforeFirstRow").setDisplayName(format("beforeFirstRow.excel", new Object[] { getDisplayName() }));
      getExcelFunction("beforeFirstRow").setGroupName(getLocalString("beforeFirstRow.excelgroup"));
    }
    if (getExcelFunction("nextRow") == null)
    {
      addChildElement(new ExcelFunction("nextRow", "boolean", "nextRow()", format("nextRow.excel", new Object[] { getDisplayName() }), null, true, getLocalString("nextRow.excelgroup")));
    }
    else
    {
      getExcelFunction("nextRow").setDisplayName(format("nextRow.excel", new Object[] { getDisplayName() }));
      getExcelFunction("nextRow").setGroupName(getLocalString("nextRow.excelgroup"));
    }
    if (getExcelFunction("insertRow") == null)
    {
      addChildElement(new ExcelFunction("insertRow", "void", "insertRow()", format("insertRow.excel", new Object[] { getDisplayName() }), null, true, getLocalString("insertRow.excelgroup")));
    }
    else
    {
      getExcelFunction("insertRow").setDisplayName(format("insertRow.excel", new Object[] { getDisplayName() }));
      getExcelFunction("insertRow").setGroupName(getLocalString("insertRow.excelgroup"));
    }
    if (getExcelFunction("deleteRow") == null)
    {
      addChildElement(new ExcelFunction("deleteRow", "void", "deleteRow()", format("deleteRow.excel", new Object[] { getDisplayName() }), null, true, getLocalString("deleteRow.excelgroup")));
    }
    else
    {
      getExcelFunction("deleteRow").setDisplayName(format("deleteRow.excel", new Object[] { getDisplayName() }));
      getExcelFunction("deleteRow").setGroupName(getLocalString("deleteRow.excelgroup"));
    }
    if (getExcelFunction("loadFromView") == null)
    {
      addChildElement(new ExcelFunction("loadFromView", "void", "loadFromView({arg1})", format("loadFromView.sheet", new Object[] { "{arg1}", getDisplayName() }), a("com.flagleader.db.IResult"), true, getLocalString("loadFromView.sheetgroup")));
    }
    else
    {
      getExcelFunction("loadFromView").setDisplayName(format("loadFromView.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getExcelFunction("loadFromView").setGroupName(getLocalString("loadFromView.sheetgroup"));
    }
    if (getExcelFunction("loadFromResult") == null)
    {
      addChildElement(new ExcelFunction("loadFromResult", "void", "loadFromResult({arg1})", format("loadFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }), a("resultandfields"), true, getLocalString("loadFromResult.sheetgroup")));
    }
    else
    {
      getExcelFunction("loadFromResult").setDisplayName(format("loadFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getExcelFunction("loadFromResult").setGroupName(getLocalString("loadFromResult.sheetgroup"));
    }
    if (getExcelFunction("appendFromResult") == null)
    {
      addChildElement(new ExcelFunction("appendFromResult", "void", "appendFromResult({arg1})", format("appendFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }), a("resultandfields"), true, getLocalString("appendFromResult.sheetgroup")));
    }
    else
    {
      getExcelFunction("appendFromResult").setDisplayName(format("appendFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getExcelFunction("appendFromResult").setGroupName(getLocalString("appendFromResult.sheetgroup"));
    }
    if (getExcelFunction("loadFromSheet") == null)
    {
      addChildElement(new ExcelFunction("loadFromSheet", "void", "loadFromSheet({arg1})", format("loadFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a("com.flagleader.db.Sheet"), true, getLocalString("loadFromSheet.sheetgroup")));
    }
    else
    {
      getExcelFunction("loadFromSheet").setDisplayName(format("loadFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getExcelFunction("loadFromSheet").setGroupName(getLocalString("loadFromSheet.sheetgroup"));
    }
    if (getExcelFunction("initFromSheet") == null)
    {
      addChildElement(new ExcelFunction("initFromSheet", "void", "initFromSheet({arg1})", format("initFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a("sheetandfields"), true, getLocalString("initFromSheet.sheetgroup")));
    }
    else
    {
      getExcelFunction("initFromSheet").setDisplayName(format("initFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getExcelFunction("initFromSheet").setGroupName(getLocalString("initFromSheet.sheetgroup"));
    }
  }

  public IExcelTableSheet getSheetData()
  {
    if ((this.sheetData == null) || (getExcelBookModel().getMaxModifyTime() > this.datatime))
    {
      this.datatime = getExcelBookModel().getMaxModifyTime();
      List localList = getFields();
      FieldInfo[] arrayOfFieldInfo = new FieldInfo[localList.size()];
      for (int i = 0; i < localList.size(); i++)
        arrayOfFieldInfo[i] = b((ExcelRowModel)localList.get(i));
      IExcelTableSheet localIExcelTableSheet = ExcelFactory.newIntance().createTableSheet(getExcelBookModel().getExcelData(), getDisplayName(), getSheetReg(), arrayOfFieldInfo, this.colNameLine - 1, this.startRowLine - 1, this.startCol - 1, this.rowAmountLine);
      localIExcelTableSheet.setAcceptEmpty(this.acceptEmpty);
      localIExcelTableSheet.setMergeSame(isMergeSame());
      localIExcelTableSheet.setShowBorder(isShowBorder());
      localIExcelTableSheet.setMergeValue(isMergeValue());
      this.sheetData = localIExcelTableSheet;
      this.sheetData.beforeFirstSheet();
      this.sheetData.getNextSheet();
    }
    return this.sheetData;
  }

  public List getFields()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof ExcelRowModel))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitExcelTableSheetModel(this);
  }

  public IElement deepClone()
  {
    return new ExcelTableSheetModel(this);
  }

  public String getName()
  {
    return "ExcelTableSheetModel";
  }

  public String getValueType()
  {
    return "com.flagleader.excel.IExcelTableSheet";
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof ExcelRowModel))
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
    if (((paramIElement instanceof IVariableObject)) || ((paramIElement instanceof FieldModel)))
    {
      IBusinessObjectEditen localIBusinessObjectEditen1 = (IBusinessObjectEditen)paramIElement;
      initUndoable();
      localObject1 = new ExcelRowModel();
      ((ExcelRowModel)localObject1).setFieldPos(b(localIBusinessObjectEditen1.getValueName()));
      ((ExcelRowModel)localObject1).setValueType(localIBusinessObjectEditen1.getValueType());
      ((ExcelRowModel)localObject1).setDisplayName(localIBusinessObjectEditen1.getDisplayName());
      ((ExcelRowModel)localObject1).setVisible(true);
      if ((paramInt >= 0) && (paramInt < getChildrenCount()))
        addChildElement((IElement)localObject1, paramInt);
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
        if ((localObject2 instanceof ExcelRowModel))
        {
          addChildElement((ExcelRowModel)localObject2, paramInt++);
          i = 1;
        }
        else
        {
          if ((!(localObject2 instanceof IVariableObject)) && (!(localObject2 instanceof FieldModel)))
            continue;
          IBusinessObjectEditen localIBusinessObjectEditen2 = (IBusinessObjectEditen)localObject2;
          initUndoable();
          ExcelRowModel localExcelRowModel = new ExcelRowModel();
          localExcelRowModel.setFieldPos(b(localIBusinessObjectEditen2.getValueName()));
          localExcelRowModel.setValueType(localIBusinessObjectEditen2.getValueType());
          localExcelRowModel.setDisplayName(localIBusinessObjectEditen2.getDisplayName());
          localExcelRowModel.setVisible(true);
          addChildElement(localExcelRowModel, paramInt++);
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
    return super.pasteElement(paramIElement, paramInt);
  }

  protected int b(String paramString)
  {
    if (NumberUtil.isParsedInteger(paramString))
      return NumberUtil.getInt(paramString);
    if (StringUtil.equalsRegular(paramString, "[A-Z]"))
    {
      i = 0;
      for (j = 0; j < paramString.length(); j++)
        i = i * 26 + (paramString.charAt(j) - 'A' + 1);
      return i - 1;
    }
    int i = -1;
    for (int j = 0; j < a().size(); j++)
    {
      if ((!(a().get(j) instanceof ExcelRowModel)) || (((ExcelRowModel)a().get(j)).getFieldPos() <= i))
        continue;
      i = ((ExcelRowModel)a().get(j)).getFieldPos();
    }
    return i + 1;
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

  public short getStartCol()
  {
    return this.startCol;
  }

  public void setStartCol(short paramShort)
  {
    this.startCol = paramShort;
  }

  public short getRowAmountLine()
  {
    return this.rowAmountLine;
  }

  public void setRowAmountLine(short paramShort)
  {
    this.rowAmountLine = paramShort;
  }

  public int getAcceptEmpty()
  {
    return this.acceptEmpty;
  }

  public void setAcceptEmpty(int paramInt)
  {
    this.acceptEmpty = paramInt;
  }

  public boolean isMergeSame()
  {
    return this.mergeSame;
  }

  public void setMergeSame(boolean paramBoolean)
  {
    this.mergeSame = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.ExcelTableSheetModel
 * JD-Core Version:    0.6.0
 */
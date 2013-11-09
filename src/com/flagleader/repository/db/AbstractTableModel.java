package com.flagleader.repository.db;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class AbstractTableModel extends AbstractBOAndContainer
  implements ISelectObject, IBOAndContainer
{
  protected int a = 0;

  public AbstractTableModel()
  {
  }

  public AbstractTableModel(AbstractTableModel paramAbstractTableModel)
  {
    super(paramAbstractTableModel);
    this.a = paramAbstractTableModel.a;
  }

  public AbstractTableModel(String paramString)
  {
    super(paramString);
  }

  public FieldModel getField(String paramString)
  {
    List localList = getFields();
    for (int i = 0; i < localList.size(); i++)
    {
      FieldModel localFieldModel = (FieldModel)localList.get(i);
      if (localFieldModel.getFieldName().equalsIgnoreCase(paramString))
        return localFieldModel;
    }
    return null;
  }

  public void updateDisplayNames()
  {
    changeDisplayName(getDisplayName());
    setModified(true);
  }

  public List getFields()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof FieldModel))
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
      arrayOfString[i] = ((FieldModel)localList.get(i)).getFieldName();
    return arrayOfString;
  }

  public List getFieldNameList()
  {
    List localList = getFields();
    ArrayList localArrayList = new ArrayList(localList.size());
    for (int i = 0; i < localList.size(); i++)
      localArrayList.add(((FieldModel)localList.get(i)).getFieldName());
    return localArrayList;
  }

  public String[] getFieldDisNames()
  {
    List localList = getFields();
    String[] arrayOfString = new String[localList.size()];
    for (int i = 0; i < localList.size(); i++)
      arrayOfString[i] = ((FieldModel)localList.get(i)).getDisplayName();
    return arrayOfString;
  }

  public void changeFieldDisplayName(FieldModel paramFieldModel)
  {
    TableFunction localTableFunction = getFieldGetFunc(paramFieldModel);
    if (localTableFunction != null)
      localTableFunction.setDisplayName(paramFieldModel.getDisplayName());
    localTableFunction = getFieldSetFunc(paramFieldModel);
    if (localTableFunction != null)
      localTableFunction.setDisplayName(paramFieldModel.getDisplayName() + " " + getLocalString("equels.table") + "{arg1}");
  }

  public void changeFieldType(FieldModel paramFieldModel)
  {
    TableFunction localTableFunction = getFieldGetFunc(paramFieldModel);
    if (localTableFunction != null)
    {
      localTableFunction.setValueType(paramFieldModel.getValueType());
      localTableFunction.setVariableName("get" + getTypeManager().a(paramFieldModel.getJavaType()) + "(\"" + paramFieldModel.getFieldName().toLowerCase() + "\")");
    }
  }

  protected List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new MethodParam(paramString, 0));
    return localArrayList;
  }

  protected List a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList(2);
    localArrayList.add(new MethodParam(paramString1, 0));
    localArrayList.add(new MethodParam(paramString2, 1));
    return localArrayList;
  }

  public TableFunction getFieldGetFunc(FieldModel paramFieldModel)
  {
    List localList = e();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof TableFunction)) && (((TableFunction)localList.get(i)).getValueName().equalsIgnoreCase("get" + paramFieldModel.getGSName())))
        return (TableFunction)localList.get(i);
    return null;
  }

  public TableFunction getFieldSetFunc(FieldModel paramFieldModel)
  {
    List localList = e();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof TableFunction)) && (((TableFunction)localList.get(i)).getValueName().equalsIgnoreCase("set" + paramFieldModel.getGSName())))
        return (TableFunction)localList.get(i);
    return null;
  }

  public TableFunction getTableFunction(String paramString)
  {
    List localList = e();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof TableFunction)) && (((TableFunction)localList.get(i)).getValueName().equals(paramString)))
        return (TableFunction)localList.get(i);
    return null;
  }

  public boolean canCreateEditen()
  {
    return false;
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
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

  public DBModel getDBModel()
  {
    if ((getParent() != null) && ((getParent() instanceof DBModel)))
      return (DBModel)getParent();
    return null;
  }

  public void changeDisplayName(String paramString)
  {
    setDisplayName(paramString);
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  public IBusinessObjectContainer getContainer()
  {
    return getDBModel();
  }

  public String getInfo()
  {
    return getSqlInfo();
  }

  public boolean isEditVisible()
  {
    return false;
  }

  public int getResultType()
  {
    return this.a;
  }

  public void setResultType(int paramInt)
  {
    this.a = paramInt;
  }

  public TableFunction addWhereFunction(String paramString1, String paramString2, String paramString3)
  {
    TableFunction localTableFunction = new TableFunction("setWhereObject(" + paramString1 + ")", "void", "setWhereObject(\"" + paramString1 + "\",{arg1})", paramString2, a(paramString3), true, getLocalString("setWhereObject.selectgroup"));
    addChildElement(localTableFunction);
    setModified(true);
    return localTableFunction;
  }

  public void exportTitleXsl(File paramFile)
  {
    Object localObject = null;
    if (paramFile.getName().endsWith(".xls"))
      localObject = new HSSFWorkbook();
    else
      localObject = new XSSFWorkbook();
    a((Workbook)localObject);
    if (!paramFile.exists())
      paramFile.createNewFile();
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    ((Workbook)localObject).write(localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
  }

  private Workbook a(Workbook paramWorkbook)
  {
    Sheet localSheet = null;
    localSheet = paramWorkbook.createSheet(getDisplayName());
    int i = 0;
    Row localRow = localSheet.createRow(i++);
    Font localFont = paramWorkbook.createFont();
    CellStyle localCellStyle = paramWorkbook.createCellStyle();
    localCellStyle = paramWorkbook.createCellStyle();
    localCellStyle.setFont(localFont);
    localCellStyle.setWrapText(true);
    List localList = getFields();
    for (int j = 0; j < localList.size(); j++)
    {
      Cell localCell = localRow.createCell((short)j);
      localCell.setCellValue(((FieldModel)localList.get(j)).getDisplayName());
      localCell.setCellStyle(localCellStyle);
    }
    localSheet.createFreezePane(0, 1, 0, 1);
    return paramWorkbook;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.AbstractTableModel
 * JD-Core Version:    0.6.0
 */
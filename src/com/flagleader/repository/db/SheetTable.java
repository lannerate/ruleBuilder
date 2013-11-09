package com.flagleader.repository.db;

import com.flagleader.database.SQLColumn;
import com.flagleader.engine.MemoryShare;
import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.Property;
import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.I;
import com.flagleader.repository.d.s;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.rom.MethodParam;
import com.flagleader.repository.rom.TempVariable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.sql.AbstractSheet;
import com.flagleader.sql.ArraySheet;
import com.flagleader.sql.DBException;
import com.flagleader.util.ListUtil;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import com.flagleader.util.csv.CsvReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class SheetTable extends AbstractBOAndContainer
  implements IBOAndContainer, IWhileObject
{
  private String sqlSelect = "";
  private String englishName = null;
  public static final String NAME = "SheetTable";
  public static final String DISPLAYNAME = getLocalString("SheetTable.text");
  private String excelFile = "";
  private String testFile = "";
  private boolean saveValue = false;
  private transient com.flagleader.db.Sheet sheetData = null;
  private String matchFields = "";
  private boolean linkList = false;
  private int shareType = 0;
  public static final int NOTSHARE = 0;
  public static final int STATICSHARE = 1;
  public static final int COPYSHARE = 2;
  private boolean fromResource = false;
  private HashMap paramMap = new HashMap();
  private ArrayList values = null;
  private int nullDefault = 0;
  private transient CellStyle dateStyle;
  private transient CellStyle defaultStyle;
  private transient Font f2;
  private transient int line;
  private transient int sheetNum;
  private int inout = 0;
  private boolean fromDB = false;
  private String sqlScript = "";
  private long updateinternal = 60000L;
  private boolean named = false;

  public SheetTable(SheetTable paramSheetTable)
  {
    super(paramSheetTable);
    this.sqlSelect = paramSheetTable.sqlSelect;
    this.englishName = paramSheetTable.englishName;
    this.saveValue = paramSheetTable.saveValue;
    this.linkList = paramSheetTable.linkList;
    this.nullDefault = paramSheetTable.nullDefault;
    this.shareType = paramSheetTable.shareType;
    for (int i = 0; i < paramSheetTable.getSheetValues().size(); i++)
      getSheetValues().add(new SheetValue((SheetValue)paramSheetTable.getSheetValues().get(i)));
  }

  public SheetTable()
  {
  }

  public SheetTable(String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    this.sqlSelect = paramString1;
    this.englishName = paramString3;
    updateFunction();
  }

  public String toString()
  {
    return getUniqueName();
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSheetTable(this);
  }

  public String getName()
  {
    return "SheetTable";
  }

  public List getResultFields()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof SheetFieldModel))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public void clearResultFields()
  {
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(getElement(i) instanceof SheetFieldModel))
        continue;
      removeElement(i);
    }
  }

  public String getSqlSelect()
  {
    return this.sqlSelect;
  }

  public void setSqlSelect(String paramString)
  {
    this.sqlSelect = paramString;
  }

  public IElement deepClone()
  {
    return new SheetTable(this);
  }

  public void update(List paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    SheetFieldModel localSheetFieldModel;
    for (int i = 0; i < paramList.size(); i++)
    {
      SQLColumn localSQLColumn = (SQLColumn)paramList.get(i);
      localSheetFieldModel = getField(localSQLColumn.getName());
      if (localSheetFieldModel == null)
      {
        localSheetFieldModel = new SheetFieldModel();
        localArrayList.add(localSheetFieldModel);
      }
      localSheetFieldModel.update(localSQLColumn);
      localSheetFieldModel.setParent(this);
    }
    List localList = getFields();
    for (int j = 0; j < localList.size(); j++)
    {
      localSheetFieldModel = (SheetFieldModel)localList.get(j);
      removeChildElement(localSheetFieldModel);
    }
    for (j = 0; j < localArrayList.size(); j++)
      addChildElement((SheetFieldModel)localArrayList.get(j));
  }

  private void a(SheetFieldModel paramSheetFieldModel)
  {
  }

  public void changeFieldType(SheetFieldModel paramSheetFieldModel)
  {
    if (getMainPackage() != null)
      getMainPackage().changeElementType(paramSheetFieldModel);
  }

  public void changeFieldDisplayName(SheetFieldModel paramSheetFieldModel)
  {
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
    getEnvionment().reRegistAllBusinessObject();
    setModified(true);
    if ((getParent() != null) && ((getParent() instanceof ITreeNode)))
      ((ITreeNode)getParent()).setModified(true);
  }

  public void changeVarName(String paramString)
  {
    setEnglishName(paramString);
  }

  public void changeSqlText(String paramString)
  {
    if (getDBModel() != null)
    {
      update(getDBModel().getQueryUtil(paramString));
      setSqlSelect(paramString);
      if (getTableFunction("loadFromSql") != null)
      {
        getTableFunction("loadFromSql").setVariableName("loadFromSql(\"" + h() + "\"," + i() + ")");
        if (j().length() > 0)
          getTableFunction("loadFromSql").setDisplayName(format("loadFromSql2.sheet", new Object[] { j(), getDisplayName() }));
        else
          getTableFunction("loadFromSql").setDisplayName(format("loadFromSql.sheet", new Object[] { getDisplayName() }));
        getTableFunction("loadFromSql").setParams(k());
        if (getMainPackage() != null)
          getMainPackage().changeParamType(getTableFunction("loadFromSql"));
      }
      else if (j().length() > 0)
      {
        addChildElement(new TableFunction("loadFromSql", "void", "loadFromSql(\"" + h() + "\"," + i() + ")", format("loadFromSql2.sheet", new Object[] { j(), getDisplayName() }), k(), true, getLocalString("loadFromSql2.sheetgroup")));
      }
      else
      {
        addChildElement(new TableFunction("loadFromSql", "void", "loadFromSql(\"" + h() + "\"," + i() + ")", format("loadFromSql.sheet", new Object[] { getDisplayName() }), k(), true, getLocalString("loadFromSql.sheetgroup")));
      }
    }
  }

  public boolean refresh()
  {
    if ((getDBModel() != null) && (this.sqlSelect.length() > 0))
    {
      update(getDBModel().getQueryUtil(this.sqlSelect));
      if (getTableFunction("loadFromSql") != null)
      {
        getTableFunction("loadFromSql").setVariableName("loadFromSql(\"" + h() + "\"," + i() + ")");
        if (j().length() > 0)
          getTableFunction("loadFromSql").setDisplayName(format("loadFromSql2.sheet", new Object[] { j(), getDisplayName() }));
        else
          getTableFunction("loadFromSql").setDisplayName(format("loadFromSql.sheet", new Object[] { getDisplayName() }));
        getTableFunction("loadFromSql").setParams(k());
        if (getMainPackage() != null)
          getMainPackage().changeParamType(getTableFunction("loadFromSql"));
      }
      else if (j().length() > 0)
      {
        addChildElement(new TableFunction("loadFromSql", "void", "loadFromSql(\"" + h() + "\"," + i() + ")", format("loadFromSql2.sheet", new Object[] { j(), getDisplayName() }), k(), true, getLocalString("loadFromSql2.sheetgroup")));
      }
      else
      {
        addChildElement(new TableFunction("loadFromSql", "void", "loadFromSql(\"" + h() + "\"," + i() + ")", format("loadFromSql.sheet", new Object[] { getDisplayName() }), k(), true, getLocalString("loadFromSql.sheetgroup")));
      }
      return true;
    }
    return false;
  }

  public void updateFunction()
  {
    if ((getTableFunction("loadFromSql") == null) && (!StringUtil.isEmpty(getSqlSelect())))
      if (j().length() > 0)
        addChildElement(new TableFunction("loadFromSql", "void", "loadFromSql(\"" + h() + "\"," + i() + ")", format("loadFromSql2.sheet", new Object[] { j(), getDisplayName() }), k(), true, getLocalString("loadFromSql2.sheetgroup")));
      else
        addChildElement(new TableFunction("loadFromSql", "void", "loadFromSql(\"" + h() + "\"," + i() + ")", format("loadFromSql.sheet", new Object[] { getDisplayName() }), k(), true, getLocalString("loadFromSql.sheetgroup")));
    if (getTableFunction("loadFromView") == null)
    {
      addChildElement(new TableFunction("loadFromView", "void", "loadFromView({arg1})", format("loadFromView.sheet", new Object[] { "{arg1}", getDisplayName() }), a("com.flagleader.db.IResult"), true, getLocalString("loadFromView.sheetgroup")));
    }
    else
    {
      getTableFunction("loadFromView").setDisplayName(format("loadFromView.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("loadFromView").setGroupName(getLocalString("loadFromView.sheetgroup"));
    }
    if (getTableFunction("loadFromResult") == null)
    {
      addChildElement(new TableFunction("loadFromResult", "void", "loadFromResult({arg1})", format("loadFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }), a("resultandfields"), true, getLocalString("loadFromResult.sheetgroup")));
    }
    else
    {
      getTableFunction("loadFromResult").setDisplayName(format("loadFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("loadFromResult").setGroupName(getLocalString("loadFromResult.sheetgroup"));
    }
    if (getTableFunction("appendFromResult") == null)
    {
      addChildElement(new TableFunction("appendFromResult", "void", "appendFromResult({arg1})", format("appendFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }), a("resultandfields"), true, getLocalString("appendFromResult.sheetgroup")));
    }
    else
    {
      getTableFunction("appendFromResult").setDisplayName(format("appendFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("appendFromResult").setGroupName(getLocalString("appendFromResult.sheetgroup"));
    }
    if (getTableFunction("updateBySheet") == null)
    {
      addChildElement(new TableFunction("updateBySheet", "void", "updateBySheet({arg1},{arg2},{arg3})", format("updateBySheet.sheet", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }), a(new String[] { "com.flagleader.db.Sheet", "sheetfields", "sheetfields" }), true, getLocalString("updateBySheet.sheetgroup")));
    }
    else
    {
      getTableFunction("updateBySheet").setDisplayName(format("updateBySheet.sheet", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }));
      getTableFunction("updateBySheet").setGroupName(getLocalString("updateBySheet.sheetgroup"));
    }
    if (getTableFunction("updateFromSheet") == null)
    {
      addChildElement(new TableFunction("updateFromSheet", "void", "updateFromSheet({arg1})", format("updateFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a(new String[] { "sheetandwheres" }), true, getLocalString("updateFromSheet.sheetgroup")));
    }
    else
    {
      getTableFunction("updateFromSheet").setDisplayName(format("updateFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("updateFromSheet").setGroupName(getLocalString("updateFromSheet.sheetgroup"));
    }
    if (getTableFunction("updateByResult") == null)
    {
      addChildElement(new TableFunction("updateByResult", "void", "updateByResult({arg1},{arg2},{arg3})", format("updateByResult.sheet", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }), a(new String[] { "com.flagleader.db.IResult", "sheetfields", "sheetfields" }), true, getLocalString("updateByResult.sheetgroup")));
    }
    else
    {
      getTableFunction("updateByResult").setDisplayName(format("updateByResult.sheet", new Object[] { "{arg1}", getDisplayName(), "{arg2}", "{arg3}" }));
      getTableFunction("updateByResult").setGroupName(getLocalString("updateByResult.sheetgroup"));
    }
    if (getTableFunction("updateFromResult") == null)
    {
      addChildElement(new TableFunction("updateFromResult", "void", "updateFromResult({arg1})", format("updateFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }), a(new String[] { "resultandwheres" }), true, getLocalString("updateFromResult.sheetgroup")));
    }
    else
    {
      getTableFunction("updateFromResult").setDisplayName(format("updateFromResult.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("updateFromResult").setGroupName(getLocalString("updateFromResult.sheetgroup"));
    }
    if (getTableFunction("loadFromSheet") == null)
    {
      addChildElement(new TableFunction("loadFromSheet", "void", "loadFromSheet({arg1})", format("loadFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a("com.flagleader.db.Sheet"), true, getLocalString("loadFromSheet.sheetgroup")));
    }
    else
    {
      getTableFunction("loadFromSheet").setDisplayName(format("loadFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("loadFromSheet").setGroupName(getLocalString("loadFromSheet.sheetgroup"));
    }
    if (getTableFunction("initFromSheet") == null)
    {
      addChildElement(new TableFunction("initFromSheet", "void", "initFromSheet({arg1})", format("initFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a("sheetandfields"), true, getLocalString("initFromSheet.sheetgroup")));
    }
    else
    {
      getTableFunction("initFromSheet").setDisplayName(format("initFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("initFromSheet").setGroupName(getLocalString("initFromSheet.sheetgroup"));
    }
    if (getTableFunction("fentan") == null)
    {
      addChildElement(new TableFunction("fentan", "void", "fentan({arg1})", format("fentan.sheet", new Object[] { "{arg1}", getDisplayName() }), a("sheetfentan"), true, getLocalString("fentan.sheetgroup")));
    }
    else
    {
      getTableFunction("fentan").setDisplayName(format("fentan.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("fentan").setGroupName(getLocalString("fentan.sheetgroup"));
    }
    if (getTableFunction("appendFromSheet") == null)
    {
      addChildElement(new TableFunction("appendFromSheet", "void", "appendFromSheet({arg1})", format("appendFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a("sheetandfields"), true, getLocalString("appendFromSheet.sheetgroup")));
    }
    else
    {
      getTableFunction("appendFromSheet").setDisplayName(format("appendFromSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("appendFromSheet").setGroupName(getLocalString("appendFromSheet.sheetgroup"));
    }
    if (getTableFunction("createSheet") == null)
    {
      addChildElement(new TableFunction("createSheet", "sheet", "createSheet({arg1},{arg2},{arg3})", format("createSheet.sheet", new Object[] { getDisplayName(), "{arg1}", "{arg2}", "{arg3}" }), a(new String[] { "sheetfuncs", "sheetfields", "sheetwheres" }), true, getLocalString("createSheet.sheetgroup")));
    }
    else
    {
      getTableFunction("createSheet").setDisplayName(format("createSheet.sheet", new Object[] { getDisplayName(), "{arg1}", "{arg2}", "{arg3}" }));
      getTableFunction("createSheet").setGroupName(getLocalString("createSheet.sheetgroup"));
    }
    if (getTableFunction("updateByDynamicSheet") == null)
    {
      addChildElement(new TableFunction("updateByDynamicSheet", "void", "updateByDynamicSheet({arg1})", format("updateByDynamicSheet.sheet", new Object[] { "{arg1}", getDisplayName() }), a(new String[] { "sheetdynamic" }), true, getLocalString("updateByDynamicSheet.sheetgroup")));
    }
    else
    {
      getTableFunction("updateByDynamicSheet").setDisplayName(format("updateByDynamicSheet.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("updateByDynamicSheet").setGroupName(getLocalString("updateByDynamicSheet.sheetgroup"));
    }
    if (getTableFunction("beforeFirst") == null)
    {
      addChildElement(new TableFunction("beforeFirst", "void", "beforeFirst()", format("beforeFirst.sheet", new Object[] { getDisplayName() }), null, getLocalString("beforeFirst.sheetgroup")));
    }
    else
    {
      getTableFunction("beforeFirst").setDisplayName(format("beforeFirst.sheet", new Object[] { getDisplayName() }));
      getTableFunction("beforeFirst").setGroupName(getLocalString("beforeFirst.sheetgroup"));
    }
    if (getTableFunction("next") == null)
    {
      addChildElement(new TableFunction("next", "boolean", "next()", format("next.sheet", new Object[] { getDisplayName() }), null, getLocalString("next.sheetgroup")));
    }
    else
    {
      getTableFunction("next").setDisplayName(format("next.sheet", new Object[] { getDisplayName() }));
      getTableFunction("next").setGroupName(getLocalString("next.sheetgroup"));
    }
    if (getTableFunction("getListResult") == null)
    {
      addChildElement(new TableFunction("getListResult", "list<list>", "getListResult()", format("getListResult.sheet", new Object[] { getDisplayName() }), null, getLocalString("getListResult.sheetgroup")));
    }
    else
    {
      getTableFunction("getListResult").setDisplayName(format("getListResult.sheet", new Object[] { getDisplayName() }));
      getTableFunction("getListResult").setGroupName(getLocalString("getListResult.sheetgroup"));
    }
    if (getTableFunction("loadFromList") == null)
    {
      addChildElement(new TableFunction("loadFromList", "void", "loadFromList({arg1})", format("loadFromList.sheet", new Object[] { "{arg1}", getDisplayName() }), a("list<list>"), true, getLocalString("loadFromList.sheetgroup")));
    }
    else
    {
      getTableFunction("loadFromList").setDisplayName(format("loadFromList.sheet", new Object[] { "{arg1}", getDisplayName() }));
      getTableFunction("loadFromList").setGroupName(getLocalString("loadFromList.sheetgroup"));
    }
    if (getTableFunction("getRows") == null)
    {
      addChildElement(new TableFunction("getRows", "int", "getRows()", format("getRows.sheet", new Object[] { getDisplayName() }), null, getLocalString("getRows.sheetgroup")));
    }
    else
    {
      getTableFunction("getRows").setDisplayName(format("getRows.sheet", new Object[] { getDisplayName() }));
      getTableFunction("getRows").setGroupName(getLocalString("getRows.sheetgroup"));
    }
    if (getTableFunction("first") == null)
    {
      addChildElement(new TableFunction("first", "boolean", "first()", format("first.sheet", new Object[] { getDisplayName() }), null, getLocalString("first.sheetgroup")));
    }
    else
    {
      getTableFunction("first").setDisplayName(format("first.sheet", new Object[] { getDisplayName() }));
      getTableFunction("first").setGroupName(getLocalString("first.sheetgroup"));
    }
    if (getTableFunction("afterLast") == null)
    {
      addChildElement(new TableFunction("afterLast", "void", "afterLast()", format("afterLast.sheet", new Object[] { getDisplayName() }), null, getLocalString("afterLast.sheetgroup")));
    }
    else
    {
      getTableFunction("afterLast").setDisplayName(format("afterLast.sheet", new Object[] { getDisplayName() }));
      getTableFunction("afterLast").setGroupName(getLocalString("afterLast.sheetgroup"));
    }
    if (getTableFunction("previous") == null)
    {
      addChildElement(new TableFunction("previous", "boolean", "previous()", format("previous.sheet", new Object[] { getDisplayName() }), null, getLocalString("previous.sheetgroup")));
    }
    else
    {
      getTableFunction("previous").setDisplayName(format("previous.sheet", new Object[] { getDisplayName() }));
      getTableFunction("previous").setGroupName(getLocalString("previous.sheetgroup"));
    }
    if (getTableFunction("last") == null)
    {
      addChildElement(new TableFunction("last", "boolean", "last()", format("last.sheet", new Object[] { getDisplayName() }), null, getLocalString("last.sheetgroup")));
    }
    else
    {
      getTableFunction("last").setDisplayName(format("last.sheet", new Object[] { getDisplayName() }));
      getTableFunction("last").setGroupName(getLocalString("last.sheetgroup"));
    }
    if (getTableFunction("getCurrentRow") == null)
    {
      addChildElement(new TableFunction("getCurrentRow", "int", "getCurrentRow()", format("getCurrentRow.sheet", new Object[] { getDisplayName() }), null, getLocalString("getCurrentRow.sheetgroup")));
    }
    else
    {
      getTableFunction("getCurrentRow").setDisplayName(format("getCurrentRow.sheet", new Object[] { getDisplayName() }));
      getTableFunction("getCurrentRow").setGroupName(getLocalString("getCurrentRow.sheetgroup"));
    }
    if (getTableFunction("gotoRow") == null)
    {
      addChildElement(new TableFunction("gotoRow", "boolean", "gotoRow({arg1})", format("gotoRow.sheet", new Object[] { getDisplayName(), "{arg1}" }), a("int"), getLocalString("gotoRow.sheetgroup")));
    }
    else
    {
      getTableFunction("gotoRow").setDisplayName(format("gotoRow.sheet", new Object[] { getDisplayName(), "{arg1}" }));
      getTableFunction("gotoRow").setGroupName(getLocalString("gotoRow.sheetgroup"));
    }
    if (getTableFunction("insert") == null)
    {
      addChildElement(new TableFunction("insert", "void", "insert()", format("insert.sheet", new Object[] { getDisplayName() }), null, getLocalString("insert.sheetgroup")));
    }
    else
    {
      getTableFunction("insert").setDisplayName(format("insert.sheet", new Object[] { getDisplayName() }));
      getTableFunction("insert").setGroupName(getLocalString("insert.sheetgroup"));
    }
    if (getTableFunction("delete") == null)
    {
      addChildElement(new TableFunction("delete", "void", "delete()", format("delete.sheet", new Object[] { getDisplayName() }), null, getLocalString("delete.sheetgroup")));
    }
    else
    {
      getTableFunction("delete").setDisplayName(format("delete.sheet", new Object[] { getDisplayName() }));
      getTableFunction("delete").setGroupName(getLocalString("delete.sheetgroup"));
    }
    if (getTableFunction("resetValues") == null)
    {
      addChildElement(new TableFunction("resetValues", "void", "resetValues()", format("resetValues.sheet", new Object[] { getDisplayName() }), null, getLocalString("resetValues.sheetgroup")));
    }
    else
    {
      getTableFunction("resetValues").setDisplayName(format("resetValues.sheet", new Object[] { getDisplayName() }));
      getTableFunction("resetValues").setGroupName(getLocalString("resetValues.sheetgroup"));
    }
    if (getTableFunction("setFieldList") == null)
    {
      addChildElement(new TableFunction("setFieldList", "void", "setFieldList({arg1},{arg2})", format("setFieldList.sheet", new Object[] { getDisplayName(), "{arg1}", "{arg2}" }), a(new String[] { "int", "list" }), true, getLocalString("setFieldList.sheetgroup")));
    }
    else
    {
      getTableFunction("setFieldList").setDisplayName(format("setFieldList.sheet", new Object[] { getDisplayName(), "{arg1}", "{arg2}" }));
      getTableFunction("setFieldList").setGroupName(getLocalString("setFieldList.sheetgroup"));
    }
  }

  private String f()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.sqlSelect.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      localStringBuffer.replace(i, j + 1, " ? ");
    }
    return localStringBuffer.toString();
  }

  private String h()
  {
    return StringUtil.replace("\"", "\\\"", f());
  }

  private String a(String paramString, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
      if (((MethodParam)paramList.get(i)).getParamName().equals(paramString))
        return ((MethodParam)paramList.get(i)).getTypeName();
    return "string";
  }

  private String i()
  {
    StringBuffer localStringBuffer1 = new StringBuffer("new Object[]{");
    StringBuffer localStringBuffer2 = new StringBuffer(this.sqlSelect.replace('\n', ' ').replace('\r', ' '));
    List localList = k();
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer2.indexOf("{", j);
      j = localStringBuffer2.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      if (localStringBuffer2.substring(i + 1, j).indexOf("arg") < 0)
      {
        k++;
        localStringBuffer1.append(getTypeManager().a(localStringBuffer2.substring(i + 1, j), new StringBuilder("arg").append(k).toString()) + ",");
        continue;
      }
      localStringBuffer1.append(getTypeManager().a(a(localStringBuffer2.substring(i + 1, j), localList), localStringBuffer2.substring(i + 1, j)) + ",");
    }
    if (localStringBuffer1.charAt(localStringBuffer1.length() - 1) == ',')
      localStringBuffer1.deleteCharAt(localStringBuffer1.length() - 1);
    localStringBuffer1.append("}");
    return localStringBuffer1.toString();
  }

  private String j()
  {
    String str = "";
    StringBuffer localStringBuffer = new StringBuffer(this.sqlSelect.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      if (localStringBuffer.substring(i + 1, j).indexOf("arg") >= 0)
        continue;
      k++;
      str = str + "{arg" + k + "}";
    }
    return str;
  }

  private List k()
  {
    ArrayList localArrayList = new ArrayList(3);
    this.paramMap.clear();
    StringBuffer localStringBuffer = new StringBuffer(this.sqlSelect.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      if (localStringBuffer.substring(i + 1, j).indexOf("arg") >= 0)
        continue;
      localArrayList.add(new MethodParam(localStringBuffer.substring(i + 1, j).trim(), k++));
      this.paramMap.put("arg" + k, b(localStringBuffer.substring(0, i).toLowerCase().trim()));
    }
    return localArrayList;
  }

  public String getParamDisplay(String paramString)
  {
    if (this.paramMap.size() == 0)
      k();
    Object localObject = this.paramMap.get(paramString);
    if (localObject != null)
    {
      SheetFieldModel localSheetFieldModel = getField(localObject.toString());
      if (localSheetFieldModel != null)
        return localSheetFieldModel.getDisplayName();
      return localObject.toString();
    }
    return "";
  }

  private String b(String paramString)
  {
    paramString = StringUtil.replace("=", "", paramString);
    paramString = StringUtil.replace("like", "", paramString);
    paramString = StringUtil.replace("in", "", paramString);
    paramString = StringUtil.replace("<", "", paramString);
    paramString = StringUtil.replace(">", "", paramString);
    paramString = paramString.trim();
    if ((paramString.lastIndexOf(".") > paramString.lastIndexOf(" ")) && (paramString.lastIndexOf(".") > 0))
      return paramString.substring(paramString.lastIndexOf(".") + 1);
    if (paramString.lastIndexOf(" ") > 0)
      return paramString.substring(paramString.lastIndexOf(" ") + 1);
    return "";
  }

  public Object[] getSelectParams(Object[] paramArrayOfObject)
  {
    ArrayList localArrayList = new ArrayList(3);
    StringBuffer localStringBuffer = new StringBuffer(this.sqlSelect.replace('\n', ' ').replace('\r', ' '));
    int i = 0;
    int j = 0;
    int k = 0;
    while (true)
    {
      i = localStringBuffer.indexOf("{", j);
      j = localStringBuffer.indexOf("}", i);
      if ((i >= j) || (i < 0))
        break;
      if (localStringBuffer.substring(i + 1, j).indexOf("arg") < 0)
      {
        localArrayList.add(paramArrayOfObject[(k++)]);
        continue;
      }
      localArrayList.add(paramArrayOfObject[(c(localStringBuffer.substring(i + 1, j)) - 1)]);
    }
    return ListUtil.toArray(localArrayList);
  }

  private int c(String paramString)
  {
    String str = "";
    for (int i = 0; i < paramString.length(); i++)
      switch (paramString.charAt(i))
      {
      case '0':
        str = str + '0';
        break;
      case '1':
        str = str + '1';
        break;
      case '2':
        str = str + '2';
        break;
      case '3':
        str = str + '3';
        break;
      case '4':
        str = str + '4';
        break;
      case '5':
        str = str + '5';
        break;
      case '6':
        str = str + '6';
        break;
      case '7':
        str = str + '7';
        break;
      case '8':
        str = str + '8';
        break;
      case '9':
        str = str + '9';
      }
    try
    {
      return Integer.parseInt(str);
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 0;
  }

  public DBModel getDBModel()
  {
    if ((getParent() != null) && ((getParent() instanceof DBModel)))
      return (DBModel)getParent();
    return null;
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
    if ((getParent() != null) && ((getParent() instanceof DBModel)))
      return getDBModel().getVarName() + "_sheet" + getParent().getElementPos(this);
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
    return "com.flagleader.db.Sheet";
  }

  public String getSqlInfo()
  {
    return getSqlSelect().replace('\n', ' ').replace('\r', ' ');
  }

  public boolean check()
  {
    if ((isDBSheet()) && (getDBModel() != null))
      return getDBModel().checkSql(getSqlSelect());
    return false;
  }

  public SheetFieldModel getField(String paramString)
  {
    List localList = getFields();
    for (int i = 0; i < localList.size(); i++)
    {
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)localList.get(i);
      if (localSheetFieldModel.getFieldName().equalsIgnoreCase(paramString))
        return localSheetFieldModel;
    }
    return null;
  }

  public boolean exitsFields(Object paramObject)
  {
    if (!(paramObject instanceof SheetFieldModel))
      return false;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (((localObject instanceof SheetFieldModel)) && (((SheetFieldModel)localObject).getFieldName().equals(((SheetFieldModel)paramObject).getFieldName())) && (((SheetFieldModel)localObject).getDisplayName().equals(((SheetFieldModel)paramObject).getDisplayName())))
        return true;
    }
    return false;
  }

  public SheetFieldModel getFieldByDisplay(String paramString)
  {
    List localList = getFields();
    for (int i = 0; i < localList.size(); i++)
    {
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)localList.get(i);
      if (localSheetFieldModel.getDisplayName().equalsIgnoreCase(paramString))
        return localSheetFieldModel;
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
    return getAcceptChildren(new b(this));
  }

  public List getFields()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < a().size(); i++)
    {
      if (!(a().get(i) instanceof SheetFieldModel))
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
      arrayOfString[i] = ((SheetFieldModel)localList.get(i)).getFieldName();
    return arrayOfString;
  }

  public String[] getFieldTypeNames()
  {
    List localList = getFields();
    String[] arrayOfString = new String[localList.size()];
    for (int i = 0; i < localList.size(); i++)
      arrayOfString[i] = ((SheetFieldModel)localList.get(i)).getValueType();
    return arrayOfString;
  }

  public g[] getFieldTypes()
  {
    List localList = getFields();
    g[] arrayOfg = new g[localList.size()];
    for (int i = 0; i < localList.size(); i++)
      arrayOfg[i] = ((SheetFieldModel)localList.get(i)).getJavaType();
    return arrayOfg;
  }

  public List getFieldNameList()
  {
    List localList = getFields();
    ArrayList localArrayList = new ArrayList(localList.size());
    for (int i = 0; i < localList.size(); i++)
      localArrayList.add(((SheetFieldModel)localList.get(i)).getFieldName());
    return localArrayList;
  }

  public String[] getFieldDisNames()
  {
    List localList = getFields();
    String[] arrayOfString = new String[localList.size()];
    for (int i = 0; i < localList.size(); i++)
      arrayOfString[i] = ((SheetFieldModel)localList.get(i)).getDisplayName();
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

  public TableFunction getFieldGetFunc(SheetFieldModel paramSheetFieldModel)
  {
    return null;
  }

  public TableFunction getFieldSetFunc(SheetFieldModel paramSheetFieldModel)
  {
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
    return true;
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    SheetFieldModel localSheetFieldModel = new SheetFieldModel();
    localSheetFieldModel.setFieldName(paramString);
    localSheetFieldModel.setValueType("string");
    addChildElement(localSheetFieldModel);
    setModified(true);
    return localSheetFieldModel;
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
    return getDBModel();
  }

  public String getInfo()
  {
    return getSqlInfo();
  }

  public boolean isEditVisible()
  {
    return true;
  }

  public void loadFieldFromExcel(String paramString)
  {
    Object localObject1 = null;
    if (paramString.toLowerCase().endsWith(".csv"))
    {
      localObject2 = new CsvReader(paramString);
      if (((CsvReader)localObject2).readRecord())
      {
        localObject3 = ((CsvReader)localObject2).getValues();
        if ((localObject3 != null) && (localObject3.length > 0))
        {
          localObject4 = getFields();
          clearResultFields();
          for (int i = 0; i < localObject3.length; i++)
          {
            localObject5 = new SheetFieldModel();
            ((SheetFieldModel)localObject5).setFieldName(String.valueOf(localObject3[i]));
            ((SheetFieldModel)localObject5).setDisplayName(String.valueOf(localObject3[i]));
            ((SheetFieldModel)localObject5).setValueType("string");
            ((SheetFieldModel)localObject5).setVisible(true);
            addChildElement((IElement)localObject5);
          }
          for (i = 0; i < ((List)localObject4).size(); i++)
          {
            localObject5 = (SheetFieldModel)((List)localObject4).get(i);
            localObject6 = getFieldByDisplay(((SheetFieldModel)localObject5).getDisplayName());
            if (localObject6 == null)
              continue;
            ((SheetFieldModel)localObject6).setUuid(((SheetFieldModel)localObject5).getUuid());
          }
          setModified(true);
          updateViewer();
        }
      }
      return;
    }
    if (paramString.toLowerCase().endsWith(".xls"))
      localObject1 = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(paramString)));
    else
      localObject1 = new XSSFWorkbook(paramString);
    Object localObject2 = ((Workbook)localObject1).getSheetAt(0);
    Object localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject5 = null;
    Object localObject6 = ((org.apache.poi.ss.usermodel.Sheet)localObject2).getRow(0);
    Row localRow = ((org.apache.poi.ss.usermodel.Sheet)localObject2).getRow(1);
    if (((Row)localObject6).getZeroHeight())
    {
      localObject6 = ((org.apache.poi.ss.usermodel.Sheet)localObject2).getRow(1);
      localRow = ((org.apache.poi.ss.usermodel.Sheet)localObject2).getRow(2);
      localObject5 = ((org.apache.poi.ss.usermodel.Sheet)localObject2).getRow(0);
    }
    if (localRow == null)
      localRow = ((org.apache.poi.ss.usermodel.Sheet)localObject2).getRow(2);
    int j = 0;
    if (localObject6 == null)
      throw new DBException("first row must input field names! can not empty!");
    for (Cell localCell = ((Row)localObject6).getCell(j++); localCell != null; localCell = ((Row)localObject6).getCell(j++))
    {
      if (localCell.getCellType() != 1)
        break;
      ((ArrayList)localObject4).add(localCell.getStringCellValue());
      if ((localObject5 != null) && (((Row)localObject5).getCell(j - 1) != null) && (((Row)localObject5).getCell(j - 1).getCellType() == 1))
        ((ArrayList)localObject3).add(((Row)localObject5).getCell(j - 1).getStringCellValue());
      else
        ((ArrayList)localObject3).add(a(j - 1));
    }
    FormulaEvaluator localFormulaEvaluator = ((Workbook)localObject1).getCreationHelper().createFormulaEvaluator();
    for (int k = 0; k < ((ArrayList)localObject4).size(); k++)
    {
      String str = "string";
      if (localRow != null)
        localCell = localRow.getCell(k);
      else
        localCell = null;
      if (localCell != null)
        switch (localCell.getCellType())
        {
        case 4:
          str = "boolean";
          break;
        case 0:
          if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(localCell))
            str = "date";
          else
            str = "double";
          break;
        case 1:
          str = "string";
          break;
        case 3:
          str = "string";
          break;
        case 5:
          break;
        case 2:
          try
          {
            CellValue localCellValue = localFormulaEvaluator.evaluate(localCell);
            switch (localCellValue.getCellType())
            {
            case 4:
              str = "boolean";
              break;
            case 0:
              str = "double";
              break;
            case 1:
              str = "string";
              break;
            case 3:
              str = "string";
              break;
            case 5:
            case 2:
            }
          }
          catch (Exception localException)
          {
            getEnvionment().getRepository().getLogger().b("error when parse" + ((ArrayList)localObject4).get(k) + localException.getLocalizedMessage());
            str = "double";
          }
        }
      localArrayList.add(str);
    }
    List localList = getFields();
    clearResultFields();
    SheetFieldModel localSheetFieldModel1;
    for (int m = 0; m < ((ArrayList)localObject4).size(); m++)
    {
      localSheetFieldModel1 = new SheetFieldModel();
      localSheetFieldModel1.setFieldName(String.valueOf(((ArrayList)localObject3).get(m)));
      localSheetFieldModel1.setDisplayName(String.valueOf(((ArrayList)localObject4).get(m)));
      localSheetFieldModel1.setValueType(String.valueOf(localArrayList.get(m)));
      localSheetFieldModel1.setVisible(true);
      addChildElement(localSheetFieldModel1);
    }
    for (m = 0; m < localList.size(); m++)
    {
      localSheetFieldModel1 = (SheetFieldModel)localList.get(m);
      SheetFieldModel localSheetFieldModel2 = getFieldByDisplay(localSheetFieldModel1.getDisplayName());
      if (localSheetFieldModel2 == null)
        continue;
      localSheetFieldModel2.setUuid(localSheetFieldModel1.getUuid());
    }
    setModified(true);
    updateViewer();
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

  public com.flagleader.db.Sheet getSheetData()
  {
    if ((this.sheetData == null) && (getSheetValues().size() > 0))
    {
      List localList = getFields();
      g[] arrayOfg = new g[localList.size()];
      for (int i = 0; i < localList.size(); i++)
        arrayOfg[i] = ((SheetFieldModel)localList.get(i)).getJavaType();
      ArraySheet localArraySheet = new ArraySheet(getFieldNames(), getFieldDisNames());
      for (int j = 0; j < getSheetValues().size(); j++)
        localArraySheet.append(((SheetValue)getSheetValues().get(j)).getValues(arrayOfg));
      this.sheetData = localArraySheet;
    }
    else if ((this.sheetData == null) && (MemoryShare.getInstance().getShareSheet(getUuid()) != null))
    {
      return MemoryShare.getInstance().getShareSheet(getUuid());
    }
    return this.sheetData;
  }

  public void setSheetData(com.flagleader.db.Sheet paramSheet)
  {
    if (this.sheetData != null)
      this.sheetData.resetValues();
    this.sheetData = paramSheet;
  }

  public String getExcelFile()
  {
    return this.excelFile;
  }

  public void setExcelFile(String paramString)
  {
    this.excelFile = paramString;
  }

  public void exportXsl(File paramFile)
  {
    Workbook localWorkbook = d(paramFile.getName());
    this.named = true;
    a(false, localWorkbook);
    if (!paramFile.exists())
      paramFile.createNewFile();
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    localWorkbook.write(localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
  }

  public void exportXsl(File paramFile, boolean paramBoolean)
  {
    Workbook localWorkbook = d(paramFile.getName());
    this.named = false;
    a(paramBoolean, localWorkbook);
    if (!paramFile.exists())
      paramFile.createNewFile();
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    localWorkbook.write(localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
  }

  private Workbook d(String paramString)
  {
    Object localObject = null;
    if (paramString.endsWith(".xls"))
      localObject = new HSSFWorkbook();
    else
      localObject = new XSSFWorkbook();
    this.dateStyle = ((Workbook)localObject).createCellStyle();
    this.dateStyle.setDataFormat(((Workbook)localObject).getCreationHelper().createDataFormat().getFormat("m/d/yy"));
    this.dateStyle.setBorderBottom(1);
    this.dateStyle.setBorderLeft(1);
    this.dateStyle.setBorderRight(1);
    this.dateStyle.setBorderTop(1);
    this.f2 = ((Workbook)localObject).createFont();
    this.f2.setFontName(MessageUtil.getString("excelDefaultFontName"));
    int i = MessageUtil.getInt("excelDefaultFontSize");
    if (i == 11)
      this.f2.setFontHeightInPoints(12);
    else
      this.f2.setFontHeightInPoints((short)i);
    this.defaultStyle = ((Workbook)localObject).createCellStyle();
    this.defaultStyle.setBorderBottom(1);
    this.defaultStyle.setBorderLeft(1);
    this.defaultStyle.setBorderRight(1);
    this.defaultStyle.setBorderTop(1);
    this.defaultStyle.setFont(this.f2);
    this.defaultStyle.setWrapText(true);
    return (Workbook)localObject;
  }

  public void exportExcelSheet(org.apache.poi.ss.usermodel.Sheet paramSheet)
  {
    Workbook localWorkbook = paramSheet.getWorkbook();
    this.dateStyle = localWorkbook.createCellStyle();
    this.dateStyle.setDataFormat(localWorkbook.getCreationHelper().createDataFormat().getFormat("m/d/yy"));
    this.dateStyle.setBorderBottom(1);
    this.dateStyle.setBorderLeft(1);
    this.dateStyle.setBorderRight(1);
    this.dateStyle.setBorderTop(1);
    this.f2 = localWorkbook.createFont();
    this.f2.setFontName(MessageUtil.getString("excelDefaultFontName"));
    int i = MessageUtil.getInt("excelDefaultFontSize");
    if (i == 11)
      this.f2.setFontHeightInPoints(12);
    else
      this.f2.setFontHeightInPoints((short)i);
    this.defaultStyle = localWorkbook.createCellStyle();
    this.defaultStyle.setBorderBottom(1);
    this.defaultStyle.setBorderLeft(1);
    this.defaultStyle.setBorderRight(1);
    this.defaultStyle.setBorderTop(1);
    this.defaultStyle.setFont(this.f2);
    this.defaultStyle.setWrapText(true);
    this.line = 0;
    Row localRow = paramSheet.createRow(this.line++);
    List localList = getFields();
    Cell localCell;
    if (this.named)
    {
      for (j = 0; j < localList.size(); j++)
      {
        localCell = localRow.createCell((short)j);
        localCell.setCellValue(((SheetFieldModel)localList.get(j)).getFieldName());
        localCell.setCellStyle(this.defaultStyle);
      }
      localRow.setZeroHeight(true);
      localRow = paramSheet.createRow(this.line++);
    }
    for (int j = 0; j < localList.size(); j++)
    {
      localCell = localRow.createCell((short)j);
      localCell.setCellValue(((SheetFieldModel)localList.get(j)).getDisplayName());
      localCell.setCellStyle(this.defaultStyle);
    }
    if (this.named)
      paramSheet.createFreezePane(0, 2, 0, 2);
    else
      paramSheet.createFreezePane(0, 1, 0, 1);
    com.flagleader.db.Sheet localSheet = getSheetData();
    if (localSheet != null)
    {
      localSheet.beforeFirst();
      while (localSheet.next())
        a(paramSheet, localSheet.getCurrentValues(), localList, this.defaultStyle);
    }
    a(paramSheet, localList.size());
  }

  private org.apache.poi.ss.usermodel.Sheet a(boolean paramBoolean, Workbook paramWorkbook, List paramList)
  {
    this.sheetNum += 1;
    org.apache.poi.ss.usermodel.Sheet localSheet = null;
    localSheet = paramWorkbook.createSheet("Sheet" + this.sheetNum);
    this.line = 0;
    Row localRow = localSheet.createRow(this.line++);
    Cell localCell;
    if (this.named)
    {
      for (i = 0; i < paramList.size(); i++)
      {
        localCell = localRow.createCell((short)i);
        localCell.setCellValue(((SheetFieldModel)paramList.get(i)).getFieldName());
        localCell.setCellStyle(this.defaultStyle);
      }
      localRow.setZeroHeight(true);
      localRow = localSheet.createRow(this.line++);
    }
    for (int i = 0; i < paramList.size(); i++)
      if (paramBoolean)
      {
        localCell = localRow.createCell(i * 3);
        localCell.setCellValue(((SheetFieldModel)paramList.get(i)).getDisplayName() + getLocalString("sheetresult.text"));
        localCell.setCellStyle(this.defaultStyle);
        localCell = localRow.createCell((short)(i * 3 + 1));
        localCell.setCellValue(((SheetFieldModel)paramList.get(i)).getDisplayName() + getLocalString("sheetresult1.text"));
        localCell.setCellStyle(this.defaultStyle);
        localCell = localRow.createCell((short)(i * 3 + 2));
        localCell.setCellValue(((SheetFieldModel)paramList.get(i)).getDisplayName() + getLocalString("sheetresult2.text"));
        localCell.setCellStyle(this.defaultStyle);
      }
      else
      {
        localCell = localRow.createCell((short)i);
        localCell.setCellValue(((SheetFieldModel)paramList.get(i)).getDisplayName());
        localCell.setCellStyle(this.defaultStyle);
      }
    if (this.named)
      localSheet.createFreezePane(0, 2, 0, 2);
    else
      localSheet.createFreezePane(0, 1, 0, 1);
    return localSheet;
  }

  private Workbook a(boolean paramBoolean, Workbook paramWorkbook)
  {
    List localList = getFields();
    this.sheetNum = 0;
    org.apache.poi.ss.usermodel.Sheet localSheet = a(paramBoolean, paramWorkbook, localList);
    com.flagleader.db.Sheet localSheet1 = getSheetData();
    if (paramBoolean)
    {
      com.flagleader.db.Sheet localSheet2 = loadDataFromExcel(new File(this.excelFile));
      String[] arrayOfString = this.matchFields.split(",");
      int[] arrayOfInt = new int[arrayOfString.length];
      for (int i = 0; i < arrayOfString.length; i++)
        if (arrayOfString[i].length() == 0)
          arrayOfInt[i] = -1;
        else
          arrayOfInt[i] = NumberUtil.parseInt(arrayOfString[i]);
      if (localSheet1 != null)
      {
        localSheet1.beforeFirst();
        while (localSheet1.next())
        {
          if (this.line == b(localSheet))
          {
            a(localSheet, localList.size());
            localSheet = a(paramBoolean, paramWorkbook, localList);
          }
          a(localSheet, localSheet1.getCurrentValues(), a(localSheet2, arrayOfInt, localSheet1.getCurrentValues()), localList, this.defaultStyle);
        }
      }
    }
    else if (localSheet1 != null)
    {
      localSheet1.beforeFirst();
      while (localSheet1.next())
      {
        if (this.line == b(localSheet))
        {
          a(localSheet, localList.size());
          localSheet = a(paramBoolean, paramWorkbook, localList);
        }
        a(localSheet, localSheet1.getCurrentValues(), localList, this.defaultStyle);
      }
    }
    a(localSheet, localList.size());
    return paramWorkbook;
  }

  private void a(org.apache.poi.ss.usermodel.Sheet paramSheet, int paramInt)
  {
    for (int i = 0; i < paramInt; i = (short)(i + 1))
      paramSheet.autoSizeColumn(i);
    paramSheet.setColumnBreak((short)(paramInt - 1));
    if (MessageUtil.getInt("excelDefaultFontSize") == 11)
      this.f2.setFontHeightInPoints(11);
  }

  private Object[] a(com.flagleader.db.Sheet paramSheet, int[] paramArrayOfInt, Object[] paramArrayOfObject)
  {
    paramSheet.beforeFirst();
    while (paramSheet.next())
    {
      Object[] arrayOfObject = paramSheet.getCurrentValues();
      int i = 1;
      for (int j = 0; j < paramArrayOfInt.length; j++)
      {
        if ((paramArrayOfInt[j] < 0) || (a(paramArrayOfObject[paramArrayOfInt[j]], arrayOfObject[paramArrayOfInt[j]])))
          continue;
        i = 0;
        break;
      }
      if (i != 0)
        return arrayOfObject;
    }
    return null;
  }

  private boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null))
      return true;
    if ((paramObject1 == null) || (paramObject2 == null))
      return false;
    if (paramObject1.equals(paramObject2))
      return true;
    return getValue(paramObject1).equals(getValue(paramObject2));
  }

  private void a(org.apache.poi.ss.usermodel.Sheet paramSheet, Object[] paramArrayOfObject, List paramList, CellStyle paramCellStyle)
  {
    Row localRow = paramSheet.createRow(this.line++);
    for (int i = 0; i < paramArrayOfObject.length; i++)
    {
      Cell localCell = localRow.createCell((short)i);
      localCell.setCellStyle(paramCellStyle);
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)paramList.get(i);
      if ((localSheetFieldModel.getJavaType().b()) || (localSheetFieldModel.getJavaType().j()))
        localCell.setCellValue(NumberUtil.getDouble(paramArrayOfObject[i]));
      else if (localSheetFieldModel.getJavaType().e())
        localCell.setCellValue(NumberUtil.getBoolean(paramArrayOfObject[i]));
      else if ((localSheetFieldModel.getJavaType().v()) || (localSheetFieldModel.getJavaType().x()) || (localSheetFieldModel.getJavaType().w()))
        try
        {
          localCell.setCellValue(com.flagleader.util.DateUtil.getDate(paramArrayOfObject[i]));
          localCell.setCellStyle(this.dateStyle);
        }
        catch (Exception localException)
        {
          localCell.setCellValue(a(paramArrayOfObject[i]));
        }
      else
        localCell.setCellValue(a(paramArrayOfObject[i]));
    }
  }

  private String a(Object paramObject)
  {
    if (paramObject == null)
      return "";
    return String.valueOf(paramObject);
  }

  private void a(org.apache.poi.ss.usermodel.Sheet paramSheet, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, List paramList, CellStyle paramCellStyle)
  {
    Row localRow = paramSheet.createRow(this.line++);
    for (int i = 0; i < paramArrayOfObject1.length; i++)
    {
      Cell localCell1 = localRow.createCell((short)(i * 3));
      Cell localCell2 = localRow.createCell((short)(i * 3 + 1));
      Cell localCell3 = localRow.createCell((short)(i * 3 + 2));
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)paramList.get(i);
      localCell1.setCellStyle(paramCellStyle);
      localCell2.setCellStyle(paramCellStyle);
      localCell3.setCellStyle(paramCellStyle);
      if ((localSheetFieldModel.getJavaType().b()) || (localSheetFieldModel.getJavaType().j()))
      {
        localCell1.setCellValue(NumberUtil.getDouble(paramArrayOfObject1[i]));
        if (paramArrayOfObject2 == null)
          continue;
        localCell2.setCellValue(NumberUtil.getDouble(paramArrayOfObject2[i]));
        localCell3.setCellValue(NumberUtil.getDouble(paramArrayOfObject1[i]) - NumberUtil.getDouble(paramArrayOfObject2[i]));
      }
      else if (localSheetFieldModel.getJavaType().e())
      {
        localCell1.setCellValue(NumberUtil.getBoolean(paramArrayOfObject1[i]));
        if (paramArrayOfObject2 == null)
          continue;
        localCell2.setCellValue(NumberUtil.getBoolean(paramArrayOfObject2[i]));
        if (NumberUtil.getBoolean(paramArrayOfObject1[i]) == NumberUtil.getBoolean(paramArrayOfObject2[i]))
          continue;
        localCell3.setCellValue(NumberUtil.getBoolean(paramArrayOfObject1[i]));
      }
      else if ((localSheetFieldModel.getJavaType().v()) || (localSheetFieldModel.getJavaType().x()) || (localSheetFieldModel.getJavaType().w()))
      {
        try
        {
          localCell1.setCellValue(com.flagleader.util.DateUtil.getDate(paramArrayOfObject1[i]));
          localCell1.setCellStyle(this.dateStyle);
          if (paramArrayOfObject2 == null)
            continue;
          localCell2.setCellValue(com.flagleader.util.DateUtil.getDate(paramArrayOfObject2[i]));
          localCell2.setCellStyle(this.dateStyle);
          localCell3.setCellValue((com.flagleader.util.DateUtil.getDate(paramArrayOfObject1[i]).getTime() - com.flagleader.util.DateUtil.getDate(paramArrayOfObject2[i]).getTime()) / 86400000L);
        }
        catch (Exception localException)
        {
          localCell1.setCellValue(a(paramArrayOfObject1[i]));
        }
      }
      else
      {
        if (paramArrayOfObject1[i] != null)
        {
          localCell1.setCellValue(getValue(paramArrayOfObject1[i]));
          if ((paramArrayOfObject2 != null) && (!getValue(paramArrayOfObject1[i]).equals(getValue(paramArrayOfObject2[i]))))
            localCell3.setCellValue(getValue(paramArrayOfObject1[i]));
        }
        if ((paramArrayOfObject2 == null) || (paramArrayOfObject2[i] == null))
          continue;
        localCell2.setCellValue(getValue(paramArrayOfObject2[i]));
      }
    }
  }

  public String getValue(Object paramObject)
  {
    return I.a(paramObject);
  }

  public boolean moveVariable(IVariableObject paramIVariableObject)
  {
    if ((paramIVariableObject instanceof SheetFieldModel))
    {
      initUndoable();
      paramIVariableObject.getParent().removeChildElement(paramIVariableObject);
      addChildElement(paramIVariableObject);
      takeSnapshot();
      setModified(true);
      return true;
    }
    if (((paramIVariableObject instanceof TempVariable)) || ((paramIVariableObject instanceof MappingVariable)))
    {
      initUndoable();
      SheetFieldModel localSheetFieldModel = new SheetFieldModel();
      localSheetFieldModel.setFieldName(paramIVariableObject.getValueName());
      localSheetFieldModel.setDisplayName(paramIVariableObject.getDisplayName());
      localSheetFieldModel.changeValueType(paramIVariableObject.getValueType());
      localSheetFieldModel.setVisible(paramIVariableObject.isVisible());
      localSheetFieldModel.setUuid(paramIVariableObject.getUuid());
      paramIVariableObject.dispose();
      addChildElement(localSheetFieldModel);
      takeSnapshot();
      setModified(true);
      return true;
    }
    return false;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    if ((paramIElement instanceof SheetFieldModel))
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
      localObject1 = new SheetFieldModel();
      ((SheetFieldModel)localObject1).setFieldName(localIBusinessObjectEditen1.getValueName());
      ((SheetFieldModel)localObject1).setDisplayName(localIBusinessObjectEditen1.getDisplayName());
      ((SheetFieldModel)localObject1).changeValueType(localIBusinessObjectEditen1.getValueType());
      ((SheetFieldModel)localObject1).setVisible(localIBusinessObjectEditen1.isVisible());
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
        if ((localObject2 instanceof SheetFieldModel))
        {
          addChildElement((SheetFieldModel)localObject2, paramInt++);
          i = 1;
        }
        else
        {
          if ((!(localObject2 instanceof IVariableObject)) && (!(localObject2 instanceof FieldModel)))
            continue;
          IBusinessObjectEditen localIBusinessObjectEditen2 = (IBusinessObjectEditen)localObject2;
          initUndoable();
          SheetFieldModel localSheetFieldModel = new SheetFieldModel();
          localSheetFieldModel.setFieldName(localIBusinessObjectEditen2.getValueName());
          localSheetFieldModel.setDisplayName(localIBusinessObjectEditen2.getDisplayName());
          localSheetFieldModel.changeValueType(localIBusinessObjectEditen2.getValueType());
          localSheetFieldModel.setVisible(localIBusinessObjectEditen2.isVisible());
          addChildElement(localSheetFieldModel, paramInt++);
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
    return !StringUtil.isEmpty(getSqlSelect());
  }

  public com.flagleader.db.Sheet loadDataFromXml(File paramFile)
  {
    SAXBuilder localSAXBuilder = new SAXBuilder();
    Document localDocument = localSAXBuilder.build(paramFile);
    Element localElement1 = localDocument.getRootElement();
    List localList1 = localElement1.getChildren();
    String[] arrayOfString = getFieldNames();
    ArraySheet localArraySheet = new ArraySheet(getFieldNames(), getFieldDisNames());
    for (int i = 0; i < localList1.size(); i++)
    {
      Element localElement2 = (Element)localList1.get(i);
      Object[] arrayOfObject = new Object[arrayOfString.length];
      for (int j = 0; j < arrayOfString.length; j++)
      {
        arrayOfObject[j] = "";
        List localList2 = localElement2.getChildren(arrayOfString[j]);
        for (int k = 0; k < localList2.size(); k++)
        {
          arrayOfObject[j] = (arrayOfObject[j] + ((Element)localList2.get(k)).getText());
          if (k >= localList2.size() - 1)
            continue;
          arrayOfObject[j] = (arrayOfObject[j] + "|");
        }
      }
      localArraySheet.append(arrayOfObject);
    }
    return localArraySheet;
  }

  private boolean a(org.apache.poi.ss.usermodel.Sheet paramSheet)
  {
    if (paramSheet != null)
    {
      Row localRow = paramSheet.getRow(0);
      if ((localRow != null) && (localRow.getZeroHeight()))
        return true;
    }
    return false;
  }

  private boolean a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
      return true;
    for (int i = 0; i < paramArrayOfInt.length; i++)
      if (paramArrayOfInt[i] >= 0)
        return false;
    return true;
  }

  private int b(org.apache.poi.ss.usermodel.Sheet paramSheet)
  {
    if ((paramSheet.getWorkbook() instanceof HSSFWorkbook))
      return 65536;
    return 1048576;
  }

  private int[] c(org.apache.poi.ss.usermodel.Sheet paramSheet)
  {
    if (paramSheet.getRow(0) == null)
      return null;
    int i;
    int j;
    Cell localCell;
    if (a(paramSheet))
    {
      arrayOfString = getFieldNames();
      localRow = paramSheet.getRow(0);
      arrayOfInt = new int[arrayOfString.length];
      for (i = 0; i < arrayOfInt.length; i++)
      {
        arrayOfInt[i] = -1;
        for (j = 0; j < b(paramSheet); j++)
        {
          localCell = localRow.getCell(j);
          if (localCell == null)
            break;
          if ((localCell.getCellType() != 1) || (!arrayOfString[i].equalsIgnoreCase(localCell.getStringCellValue())))
            continue;
          arrayOfInt[i] = j;
          break;
        }
      }
      return arrayOfInt;
    }
    String[] arrayOfString = getFieldDisNames();
    Row localRow = paramSheet.getRow(0);
    int[] arrayOfInt = new int[arrayOfString.length];
    if (localRow != null)
      for (i = 0; i < arrayOfInt.length; i++)
      {
        arrayOfInt[i] = -1;
        for (j = 0; j < b(paramSheet); j++)
        {
          localCell = localRow.getCell(j);
          if (localCell == null)
            break;
          if ((localCell.getCellType() != 1) || (!arrayOfString[i].equalsIgnoreCase(localCell.getStringCellValue())))
            continue;
          arrayOfInt[i] = j;
          break;
        }
      }
    return arrayOfInt;
  }

  private Object[] a(int[] paramArrayOfInt, g[] paramArrayOfg, Row paramRow, int paramInt, FormulaEvaluator paramFormulaEvaluator)
  {
    Object[] arrayOfObject = new Object[paramArrayOfInt.length];
    for (int i = 0; i < paramArrayOfInt.length; i++)
    {
      if (paramArrayOfInt[i] == -1)
        continue;
      Cell localCell = paramRow.getCell(paramArrayOfInt[i]);
      if (localCell == null)
        continue;
      switch (localCell.getCellType())
      {
      case 4:
        if (paramArrayOfg[i].e())
          arrayOfObject[i] = new Boolean(localCell.getBooleanCellValue());
        else if (paramArrayOfg[i].m())
          arrayOfObject[i] = String.valueOf(localCell.getBooleanCellValue());
        else
          throw new s(format("loadSheetData.error", new String[] { String.valueOf(paramInt + 1), String.valueOf(paramArrayOfInt[i]), String.valueOf(localCell.getBooleanCellValue()) }));
      case 0:
        if ((paramArrayOfg[i].v()) || (paramArrayOfg[i].w()) || (paramArrayOfg[i].x()))
        {
          if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(localCell))
            arrayOfObject[i] = localCell.getDateCellValue();
          else
            try
            {
              arrayOfObject[i] = com.flagleader.util.DateUtil.getDate(new Double(localCell.getNumericCellValue()));
            }
            catch (Exception localException1)
            {
              throw new s(format("loadSheetData.error", new String[] { String.valueOf(paramInt + 1), String.valueOf(paramArrayOfInt[i]), String.valueOf(localCell.getNumericCellValue()) }));
            }
        }
        else if ((paramArrayOfg[i].b()) || (paramArrayOfg[i].j()))
        {
          if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(localCell))
            throw new s(format("loadSheetData.error", new String[] { String.valueOf(paramInt + 1), String.valueOf(paramArrayOfInt[i]), String.valueOf(localCell.getNumericCellValue()) }));
          double d1 = localCell.getNumericCellValue();
          if (()d1 == d1)
            arrayOfObject[i] = new Long(()d1);
          else
            arrayOfObject[i] = new Double(d1);
        }
        else if (paramArrayOfg[i].m())
        {
          if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(localCell))
            arrayOfObject[i] = Property.getInstance().formatDate(localCell.getDateCellValue());
          else
            arrayOfObject[i] = StringUtil.stringValue(localCell.getNumericCellValue());
        }
        else
        {
          throw new s(format("loadSheetData.error", new String[] { String.valueOf(paramInt + 1), String.valueOf(paramArrayOfInt[i]), String.valueOf(localCell.getNumericCellValue()) }));
        }
      case 1:
        String str = localCell.getStringCellValue();
        if (paramArrayOfg[i].m())
          arrayOfObject[i] = str;
        else if (paramArrayOfg[i].v())
          try
          {
            arrayOfObject[i] = com.flagleader.util.DateUtil.getDate(str);
          }
          catch (Exception localException2)
          {
            throw new s(format("loadSheetData.error", new String[] { String.valueOf(paramInt + 1), String.valueOf(paramArrayOfInt[i]), String.valueOf(localCell.getStringCellValue()) }));
          }
        else if (paramArrayOfg[i].k())
          arrayOfObject[i] = Integer.valueOf(NumberUtil.parseInt(NumberUtil.parseNumber(str)));
        else if (paramArrayOfg[i].h())
          arrayOfObject[i] = Long.valueOf(NumberUtil.parseLong(NumberUtil.parseNumber(str)));
        else if (paramArrayOfg[i].i())
          arrayOfObject[i] = Double.valueOf(NumberUtil.parseDouble(NumberUtil.parseNumber(str)));
        else if (paramArrayOfg[i].g())
          arrayOfObject[i] = Short.valueOf(NumberUtil.parseShort(NumberUtil.parseNumber(str)));
        else if (paramArrayOfg[i].c())
          arrayOfObject[i] = Float.valueOf(NumberUtil.parseFloat(NumberUtil.parseNumber(str)));
        else if (paramArrayOfg[i].j())
          arrayOfObject[i] = new BigDecimal(NumberUtil.parseNumber(str));
        else if (paramArrayOfg[i].d())
          arrayOfObject[i] = Character.valueOf(str.charAt(0));
        else
          throw new s(format("loadSheetData.error", new String[] { String.valueOf(paramInt + 1), String.valueOf(paramArrayOfInt[i]), String.valueOf(localCell.getStringCellValue()) }));
      case 3:
        break;
      case 5:
        break;
      case 2:
        try
        {
          CellValue localCellValue = paramFormulaEvaluator.evaluate(localCell);
          switch (localCellValue.getCellType())
          {
          case 4:
            if (paramArrayOfg[i].e())
              arrayOfObject[i] = new Boolean(localCellValue.getBooleanValue());
            else if (paramArrayOfg[i].m())
              arrayOfObject[i] = String.valueOf(localCellValue.getBooleanValue());
            else
              throw new s(format("loadSheetData.error", new String[] { String.valueOf(paramInt + 1), String.valueOf(paramArrayOfInt[i]), String.valueOf(localCellValue.getBooleanValue()) }));
          case 0:
            if ((paramArrayOfg[i].v()) || (paramArrayOfg[i].w()) || (paramArrayOfg[i].x()))
            {
              try
              {
                arrayOfObject[i] = com.flagleader.util.DateUtil.getDate(new Double(localCellValue.getNumberValue()));
              }
              catch (Exception localException4)
              {
                throw new s(format("loadSheetData.error", new String[] { String.valueOf(paramInt + 1), String.valueOf(paramArrayOfInt[i]), String.valueOf(localCell.getNumericCellValue()) }));
              }
            }
            else if ((paramArrayOfg[i].b()) || (paramArrayOfg[i].j()))
            {
              double d2 = localCellValue.getNumberValue();
              if (()d2 == d2)
                arrayOfObject[i] = new Long(()d2);
              else
                arrayOfObject[i] = new Double(d2);
            }
            else if (paramArrayOfg[i].m())
            {
              arrayOfObject[i] = StringUtil.stringValue(localCellValue.getNumberValue());
            }
            else
            {
              throw new s(format("loadSheetData.error", new String[] { String.valueOf(paramInt + 1), String.valueOf(paramArrayOfInt[i]), String.valueOf(localCell.getNumericCellValue()) }));
            }
          case 1:
            arrayOfObject[i] = localCellValue.getStringValue();
            if (paramArrayOfg[i].m())
              arrayOfObject[i] = localCellValue.getStringValue();
            else if (paramArrayOfg[i].v())
              try
              {
                arrayOfObject[i] = com.flagleader.util.DateUtil.getDate(localCellValue.getStringValue());
              }
              catch (Exception localException5)
              {
                throw new s(format("loadSheetData.error", new String[] { String.valueOf(paramInt + 1), String.valueOf(paramArrayOfInt[i]), String.valueOf(localCellValue.getStringValue()) }));
              }
            else
              throw new s(format("loadSheetData.error", new String[] { String.valueOf(paramInt + 1), String.valueOf(paramArrayOfInt[i]), String.valueOf(localCellValue.getStringValue()) }));
          case 3:
            break;
          case 5:
          case 2:
          }
        }
        catch (Exception localException3)
        {
        }
      }
    }
    return arrayOfObject;
  }

  public com.flagleader.db.Sheet loadDataFromExcel(File paramFile)
  {
    Object localObject1 = null;
    if (paramFile.getName().toLowerCase().endsWith(".csv"))
    {
      localObject2 = new ArraySheet(getFieldNames(), getFieldDisNames(), getFieldTypeNames());
      ((AbstractSheet)localObject2).loadFromCsvFile(paramFile.getPath());
      return localObject2;
    }
    if (paramFile.getName().toLowerCase().endsWith(".xls"))
      localObject1 = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(paramFile)));
    else
      localObject1 = new XSSFWorkbook(paramFile.getPath());
    Object localObject2 = getFieldTypes();
    ArraySheet localArraySheet = new ArraySheet(getFieldNames(), getFieldDisNames());
    FormulaEvaluator localFormulaEvaluator = ((Workbook)localObject1).getCreationHelper().createFormulaEvaluator();
    for (int i = 0; i < ((Workbook)localObject1).getNumberOfSheets(); i++)
    {
      org.apache.poi.ss.usermodel.Sheet localSheet = ((Workbook)localObject1).getSheetAt(i);
      if (!a(localSheet, localArraySheet, localObject2, localFormulaEvaluator))
        break;
    }
    return (com.flagleader.db.Sheet)(com.flagleader.db.Sheet)localArraySheet;
  }

  private boolean a(org.apache.poi.ss.usermodel.Sheet paramSheet, AbstractSheet paramAbstractSheet, g[] paramArrayOfg, FormulaEvaluator paramFormulaEvaluator)
  {
    if (paramSheet == null)
      return false;
    int i = 1;
    if (a(paramSheet))
      i = 2;
    int[] arrayOfInt = c(paramSheet);
    if (a(arrayOfInt))
      return false;
    for (int j = i; j < b(paramSheet); j++)
    {
      Row localRow = paramSheet.getRow(j);
      if ((localRow == null) || (localRow.getCell(0) == null))
        break;
      Object[] arrayOfObject = a(arrayOfInt, paramArrayOfg, localRow, j, paramFormulaEvaluator);
      int k = 1;
      for (int m = 0; m < arrayOfObject.length; m++)
      {
        if ((arrayOfObject[m] == null) || (arrayOfObject[m].toString().length() <= 0))
          continue;
        k = 0;
        break;
      }
      if (k != 0)
        continue;
      paramAbstractSheet.append(arrayOfObject);
    }
    return true;
  }

  public void saveValues(com.flagleader.db.Sheet paramSheet)
  {
    setSheetData(null);
    getSheetValues().clear();
    if (paramSheet != null)
    {
      List localList = getFields();
      g[] arrayOfg = new g[localList.size()];
      for (int i = 0; i < localList.size(); i++)
        arrayOfg[i] = ((SheetFieldModel)localList.get(i)).getJavaType();
      paramSheet.beforeFirst();
      while (paramSheet.next())
        addSheetValue(new SheetValue(paramSheet.getCurrentValues(), arrayOfg));
      setSaveValue(true);
    }
  }

  public List getSheetValues()
  {
    if (this.values == null)
      this.values = new ArrayList();
    return this.values;
  }

  public void addSheetValue(SheetValue paramSheetValue)
  {
    getSheetValues().add(paramSheetValue);
  }

  public boolean isSaveValue()
  {
    return this.saveValue;
  }

  public void setSaveValue(boolean paramBoolean)
  {
    this.saveValue = paramBoolean;
  }

  protected boolean a_(String paramString1, String paramString2)
  {
    if (paramString1.length() < paramString2.length())
      return false;
    return super.a_(paramString1, paramString2);
  }

  public String getMatchFields()
  {
    return this.matchFields;
  }

  public void setMatchFields(String paramString)
  {
    this.matchFields = paramString;
  }

  public List getSelectedElements()
  {
    ArrayList localArrayList = new ArrayList();
    List localList = getFields();
    String[] arrayOfString = this.matchFields.split(",");
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if ((arrayOfString[i].length() <= 0) || (localList.size() <= NumberUtil.parseInt(arrayOfString[i])))
        continue;
      localArrayList.add(localList.get(NumberUtil.parseInt(arrayOfString[i])));
    }
    return localArrayList;
  }

  public boolean isLinkList()
  {
    return this.linkList;
  }

  public void setLinkList(boolean paramBoolean)
  {
    this.linkList = paramBoolean;
  }

  public String getTestFile()
  {
    return this.testFile;
  }

  public void setTestFile(String paramString)
  {
    this.testFile = paramString;
  }

  public boolean mustWhile()
  {
    return true;
  }

  public void replaceVariables(List paramList1, List paramList2, List paramList3, List paramList4)
  {
    List localList = getFields();
    clearResultFields();
    SheetFieldModel localSheetFieldModel1;
    for (int i = 0; i < paramList1.size(); i++)
    {
      localSheetFieldModel1 = new SheetFieldModel();
      localSheetFieldModel1.setFieldName(String.valueOf(paramList1.get(i)));
      localSheetFieldModel1.setDisplayName(String.valueOf(paramList3.get(i)));
      if (String.valueOf(paramList2.get(i)).length() > 0)
        localSheetFieldModel1.setValueType(String.valueOf(paramList2.get(i)));
      else
        localSheetFieldModel1.setValueType("string");
      if (String.valueOf(paramList4.get(i)).length() > 0)
        localSheetFieldModel1.setGroupName(String.valueOf(paramList4.get(i)));
      localSheetFieldModel1.setVisible(true);
      addChildElement(localSheetFieldModel1);
    }
    for (i = 0; i < localList.size(); i++)
    {
      localSheetFieldModel1 = (SheetFieldModel)localList.get(i);
      SheetFieldModel localSheetFieldModel2 = getFieldByDisplay(localSheetFieldModel1.getDisplayName());
      if (localSheetFieldModel2 == null)
        continue;
      localSheetFieldModel2.setUuid(localSheetFieldModel1.getUuid());
    }
    setModified(true);
    updateViewer();
  }

  public String getUniqueName()
  {
    return getDisplayName();
  }

  public int getNullDefault()
  {
    return this.nullDefault;
  }

  public void setNullDefault(int paramInt)
  {
    this.nullDefault = paramInt;
  }

  public boolean isFromResource()
  {
    return this.fromResource;
  }

  public void setFromResource(boolean paramBoolean)
  {
    this.fromResource = paramBoolean;
  }

  public int getShareType()
  {
    return this.shareType;
  }

  public void setShareType(int paramInt)
  {
    this.shareType = paramInt;
  }

  private String b(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++)
    {
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)paramList.get(i);
      localStringBuffer.append(getFields().indexOf(localSheetFieldModel));
      if (i >= paramList.size() - 1)
        continue;
      localStringBuffer.append(",");
    }
    return localStringBuffer.toString();
  }

  private String c(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++)
    {
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)paramList.get(i);
      localStringBuffer.append(getTypeManager().g(localSheetFieldModel.getJavaType()));
      localStringBuffer.append("{arg").append(i + 1).append("}");
      localStringBuffer.append(getTypeManager().h(localSheetFieldModel.getJavaType()));
      if (i >= paramList.size() - 1)
        continue;
      localStringBuffer.append(",");
    }
    return localStringBuffer.toString();
  }

  protected List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList(1);
    for (int i = 0; i < paramList.size(); i++)
    {
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)paramList.get(i);
      localArrayList.add(new MethodParam(localSheetFieldModel.getValueType(), i));
    }
    return localArrayList;
  }

  private String d(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++)
    {
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)paramList.get(i);
      localStringBuffer.append(format("insertParam.sheet", new String[] { localSheetFieldModel.getDisplayName(), "{arg" + (i + 1) + "}" }));
      if (i >= paramList.size() - 1)
        continue;
      localStringBuffer.append(",");
    }
    return localStringBuffer.toString();
  }

  public void addInsertFunction(List paramList)
  {
    addChildElement(new TableFunction("insertValues(" + b(paramList) + ")", "void", "insertValues(new int[]{" + b(paramList) + "},new Object[]{" + c(paramList) + "})", format("insertValues.sheet", new String[] { getDisplayName(), d(paramList) }), a(paramList), true, getLocalString("insertValues.sheetgroup")));
    setModified(true);
  }

  public void addUpdateFunction(List paramList)
  {
    addChildElement(new TableFunction("updateValues(" + b(paramList) + ")", "void", "updateValues(new int[]{" + b(paramList) + "},new Object[]{" + c(paramList) + "})", format("updateValues.sheet", new String[] { getDisplayName(), d(paramList) }), a(paramList), true, getLocalString("updateValues.sheetgroup")));
    setModified(true);
  }

  public boolean needInit()
  {
    if ((getDBModel() != null) && (getTableFunction("loadFromSql") != null) && (!StringUtil.isEmpty(getSqlSelect())))
      return false;
    return (isSaveValue()) || (isFromResource()) || (isValidFromDB());
  }

  public boolean isValidFromDB()
  {
    return (isFromDB()) && (getDBModel() != null) && (getSqlScript().length() > 0);
  }

  public int getInout()
  {
    return this.inout;
  }

  public void setInout(int paramInt)
  {
    this.inout = paramInt;
  }

  public boolean isFromDB()
  {
    return this.fromDB;
  }

  public void setFromDB(boolean paramBoolean)
  {
    this.fromDB = paramBoolean;
  }

  public String getSqlScript()
  {
    return this.sqlScript;
  }

  public void setSqlScript(String paramString)
  {
    this.sqlScript = paramString;
  }

  public long getUpdateinternal()
  {
    return this.updateinternal;
  }

  public void setUpdateinternal(long paramLong)
  {
    this.updateinternal = paramLong;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.SheetTable
 * JD-Core Version:    0.6.0
 */
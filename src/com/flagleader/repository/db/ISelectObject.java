package com.flagleader.repository.db;

import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.IBOAndContainer;
import java.io.File;
import java.util.List;

public abstract interface ISelectObject extends IBOAndContainer
{
  public abstract TableFunction getFieldGetFunc(FieldModel paramFieldModel);

  public abstract TableFunction getFieldSetFunc(FieldModel paramFieldModel);

  public abstract TableFunction getTableFunction(String paramString);

  public abstract String getSqlInfo();

  public abstract List getFields();

  public abstract String getMainTableName();

  public abstract String[] getFieldNames();

  public abstract void changeFieldDisplayName(FieldModel paramFieldModel);

  public abstract void changeFieldType(FieldModel paramFieldModel);

  public abstract h getTypeManager();

  public abstract boolean refresh();

  public abstract boolean check();

  public abstract DBModel getDBModel();

  public abstract void exportTitleXsl(File paramFile);

  public abstract void updateFunction();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.ISelectObject
 * JD-Core Version:    0.6.0
 */
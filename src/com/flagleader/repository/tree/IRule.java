package com.flagleader.repository.tree;

import java.util.List;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;

public abstract interface IRule extends IRuleTree
{
  public abstract List getAllVars();

  public abstract Envionment getEnvionment();

  public abstract void exportExcelSheet(Sheet paramSheet, CellStyle paramCellStyle);

  public abstract void compareExcelSheet(Sheet paramSheet);

  public abstract int getRuleTableCount();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IRule
 * JD-Core Version:    0.6.0
 */
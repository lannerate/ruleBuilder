package com.flagleader.repository.export;

import com.flagleader.export.IExportPage;
import com.flagleader.export.PagesMessages;
import com.flagleader.repository.IElement;
import com.flagleader.repository.j;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.IPackageElement;
import java.util.List;

public abstract interface IPage extends IExportPage, j, IPackageElement
{
  public abstract PagesMessages getPreferences();

  public abstract boolean isEmptyProp(String paramString);

  public abstract boolean isPropValue(String paramString1, String paramString2);

  public abstract boolean isPropValueNoCase(String paramString1, String paramString2);

  public abstract String getPropertyValue(String paramString);

  public abstract String[] getKeysPre(String paramString);

  public abstract String getExeRulePackageName();

  public abstract String getExportStr();

  public abstract String getImportFile();

  public abstract List exportFile(String paramString);

  public abstract List getPageFields();

  public abstract String getTitle();

  public abstract boolean pasteElement(IElement paramIElement, int paramInt);

  public abstract PageFieldModel addMappingVariable(MappingVariable paramMappingVariable);

  public abstract String getExportFile();

  public abstract void setExportFile(String paramString);

  public abstract List getPropertiesList();

  public abstract d getExportCompiler();

  public abstract List getAllVars();

  public abstract boolean exitsDesignFile(String paramString);

  public abstract d getDesignCompiler(String paramString);

  public abstract int getInputFieldCount(String paramString);

  public abstract PageFieldModel addEmptyFieldModel();

  public abstract int getOutFieldCount(String paramString);

  public abstract String getModelStr();

  public abstract String getFName();

  public abstract String getPName();

  public abstract String getDesignStr(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.IPage
 * JD-Core Version:    0.6.0
 */
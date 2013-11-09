package com.flagleader.repository.g;

import com.flagleader.export.PagesMessages;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.db.a.e;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageFieldModel;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExportModel;
import com.flagleader.repository.tree.RulePackage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class a
{
  protected DBModel a;

  protected String a(List paramList)
  {
    String str = "";
    for (int i = 0; i < paramList.size(); i++)
    {
      if (!(paramList.get(i) instanceof TableModel))
        continue;
      str = str + ((TableModel)paramList.get(i)).getDisplayName();
    }
    return str;
  }

  protected String b(List paramList)
  {
    String str = "";
    for (int i = 0; i < paramList.size(); i++)
    {
      if (!(paramList.get(i) instanceof TableModel))
        continue;
      str = str + ((TableModel)paramList.get(i)).getTableName().toLowerCase();
    }
    return str;
  }

  protected void a(SelectTable paramSelectTable, com.flagleader.repository.db.a.a parama)
  {
    for (int i = 0; i < paramSelectTable.getFields().size(); i++)
    {
      FieldModel localFieldModel = (FieldModel)paramSelectTable.getFields().get(i);
      List localList = parama.c();
      for (int j = 0; j < localList.size(); j++)
      {
        e locale = (e)localList.get(j);
        if (!locale.a().getFieldName().equalsIgnoreCase(localFieldModel.getFieldName()))
          continue;
        localFieldModel.setDisplayName(locale.a().getDisplayName());
      }
    }
  }

  protected DBModel a(RulePackage paramRulePackage)
  {
    DBModel localDBModel = new DBModel();
    localDBModel.setDriver(this.a.getDriver());
    localDBModel.setUrl(this.a.getUrl());
    localDBModel.setUserName(this.a.getUserName());
    localDBModel.setPasswd(this.a.getPasswd());
    localDBModel.setDatasourceName(this.a.getDisplayName());
    localDBModel.setDisplayName(this.a.getDisplayName());
    localDBModel.setSchemaName(this.a.getSchemaName());
    localDBModel.setCatalogName(this.a.getCatalogName());
    paramRulePackage.getEnvionment().addChildElement(localDBModel);
    return localDBModel;
  }

  protected List c(List paramList)
  {
    List localList = null;
    for (int i = 0; i < paramList.size(); i++)
    {
      TableModel localTableModel = (TableModel)paramList.get(i);
      localList = localTableModel.getPrimaryKeys();
      if (localList.size() == 0)
        localList = localTableModel.getFields();
      if (a(localList, paramList))
        return localList;
    }
    return localList;
  }

  protected boolean a(List paramList1, List paramList2)
  {
    for (int i = 0; i < paramList2.size(); i++)
    {
      TableModel localTableModel = (TableModel)paramList2.get(i);
      int j = 1;
      for (int k = 0; k < paramList1.size(); k++)
      {
        if (localTableModel.getField(((FieldModel)paramList1.get(k)).getFieldName()) != null)
          continue;
        j = 0;
        break;
      }
      if (j == 0)
        return false;
    }
    return true;
  }

  protected boolean a(List paramList, String paramString)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      TableModel localTableModel = (TableModel)paramList.get(i);
      if (localTableModel.getTableName().equalsIgnoreCase(paramString))
        return true;
    }
    return false;
  }

  protected void a(ExportModel paramExportModel, PageFieldModel paramPageFieldModel)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = paramPageFieldModel.getPageTypes();
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      String[] arrayOfString3 = paramExportModel.getPreferences().getStringArray(arrayOfString1[i] + ".prop");
      if ((arrayOfString3 == null) || (arrayOfString3.length <= 0))
        continue;
      for (int m = 0; m < arrayOfString3.length; m++)
      {
        if (localHashMap.get(arrayOfString3[m]) != null)
          continue;
        localHashMap.put(arrayOfString3[m], arrayOfString3[m]);
        localArrayList.add(arrayOfString3[m]);
      }
    }
    String[] arrayOfString2;
    if ((paramPageFieldModel.getParent() instanceof IPage))
    {
      if (paramExportModel.getPreferences().getStringArray(((IPage)paramPageFieldModel.getParent()).getImportFile() + ".fprops") != null)
      {
        arrayOfString2 = paramExportModel.getPreferences().getStringArray(((IPage)paramPageFieldModel.getParent()).getImportFile() + ".fprops");
        for (int k = 0; k < arrayOfString2.length; k++)
        {
          if ((localHashMap.get(arrayOfString2[k]) != null) || (arrayOfString2[k].endsWith("_")))
            continue;
          localHashMap.put(arrayOfString2[k], arrayOfString2[k]);
          localArrayList.add(arrayOfString2[k]);
        }
      }
    }
    else if ((paramPageFieldModel.getParent() instanceof PageFieldModel))
    {
      arrayOfString2 = (String[])null;
      PageFieldModel localPageFieldModel = (PageFieldModel)paramPageFieldModel.getParent();
      if (paramExportModel.getPreferences().getStringArray(localPageFieldModel.getInputType() + ".fprops") != null)
        arrayOfString2 = paramExportModel.getPreferences().getStringArray(localPageFieldModel.getInputType() + ".fprops");
      else if (paramExportModel.getPreferences().getStringArray(localPageFieldModel.getResultType() + ".fprops") != null)
        arrayOfString2 = paramExportModel.getPreferences().getStringArray(localPageFieldModel.getResultType() + ".fprops");
      a(arrayOfString2, localHashMap, localArrayList);
    }
    a(paramExportModel.getPreferences().getStringArray("field.fprops"), localHashMap, localArrayList);
    if (localArrayList.size() > 0)
      for (int j = 0; j < localArrayList.size(); j++)
      {
        if ((paramPageFieldModel.getProperty(localArrayList.get(j).toString()) != null) || (paramExportModel.getPreferences().getString(localArrayList.get(j).toString() + ".defaultvalue", "").length() <= 0))
          continue;
        paramPageFieldModel.setPropertyValue(localArrayList.get(j).toString(), paramExportModel.getPreferences().getString(localArrayList.get(j).toString() + ".defaultvalue", ""));
      }
  }

  protected void a(String[] paramArrayOfString, HashMap paramHashMap, ArrayList paramArrayList)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
      for (int i = 0; i < paramArrayOfString.length; i++)
      {
        if ((paramHashMap.get(paramArrayOfString[i]) != null) || (paramArrayOfString[i].endsWith("_")))
          continue;
        paramHashMap.put(paramArrayOfString[i], paramArrayOfString[i]);
        paramArrayList.add(paramArrayOfString[i]);
      }
  }

  protected void a(PageFieldModel paramPageFieldModel, String paramString)
  {
    String[] arrayOfString = paramPageFieldModel.getPage().getPreferences().getStringArray(paramString + ".prop");
    if ((arrayOfString != null) && (arrayOfString.length > 0))
      for (int i = 0; i < arrayOfString.length; i++)
      {
        if (!paramPageFieldModel.isEmptyProp(arrayOfString[i]))
          continue;
        paramPageFieldModel.setPropertyValue(arrayOfString[i], paramPageFieldModel.getPage().getPreferences().getString(arrayOfString[i] + ".defaultvalue", ""));
      }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.g.a
 * JD-Core Version:    0.6.0
 */
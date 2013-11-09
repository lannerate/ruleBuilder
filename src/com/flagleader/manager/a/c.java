package com.flagleader.manager.a;

import com.flagleader.manager.r;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.FunctionLibrary;
import com.flagleader.util.RuleClassLoader;
import java.io.File;

public class c
{
  r a = null;

  public c(r paramr)
  {
    this.a = paramr;
  }

  public void a(Envionment paramEnvionment, String paramString1, String paramString2)
  {
    if ((paramString2 == null) || (paramString2.length() == 0))
      return;
    paramEnvionment.loadClass(paramString1, paramString2);
  }

  public void a(Envionment paramEnvionment, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return;
    paramEnvionment.getFunctionLibrary().loadClass(paramString);
  }

  public void a(Envionment paramEnvionment, File paramFile)
  {
    Class localClass = new RuleClassLoader(getClass().getClassLoader()).loadClassFromFile(null, paramFile);
    if (localClass == null)
      throw new ClassNotFoundException();
    String str1 = localClass.getName();
    String str2 = paramFile.getPath();
    String str3 = str2.substring(0, str2.lastIndexOf(str1.replace('.', File.separatorChar)));
    a(paramEnvionment, str3, str1);
  }

  public void a(Envionment paramEnvionment, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    DBModel localDBModel = new DBModel(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    localDBModel.setDisplayName(paramString8);
    paramEnvionment.addChildElement(localDBModel);
    paramEnvionment.setModified(true);
    paramEnvionment.updateTree();
  }

  public void a(Envionment paramEnvionment, String paramString1, String paramString2, String paramString3)
  {
    ExcelBookModel localExcelBookModel = new ExcelBookModel(paramString1, paramString2, paramString3);
    paramEnvionment.addChildElement(localExcelBookModel);
    paramEnvionment.setModified(true);
    paramEnvionment.updateTree();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.c
 * JD-Core Version:    0.6.0
 */
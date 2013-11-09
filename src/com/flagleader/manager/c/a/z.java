package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.f;
import com.flagleader.manager.c.l;
import com.flagleader.manager.r;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.tree.ITreeNode;

public class z extends e
{
  public z(com.flagleader.manager.c.c paramc, ExcelBookModel paramExcelBookModel, r paramr)
  {
    super(paramc, paramExcelBookModel, paramr);
  }

  public void a()
  {
    if (f().isDevelopModel())
    {
      a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
      a(com.flagleader.manager.d.c.b("disName.ExcelBookProperties"), new l(this));
      a(com.flagleader.manager.d.c.b("varName.ExcelBookProperties"), new A(this));
      a(com.flagleader.manager.d.c.b("modelFile.ExcelBookProperties"), new C(this));
      a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new f(this));
      a(com.flagleader.manager.d.c.b("excel.ExcelBookProperties"), new B(this));
    }
  }

  public ExcelBookModel f()
  {
    if ((d() != null) && ((d() instanceof ExcelBookModel)))
      return (ExcelBookModel)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.z
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.a.a;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.br;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.i;
import com.flagleader.db.Sheet;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.I;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.lang.g;
import com.flagleader.util.DateUtil;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public class M extends aS
  implements br, IElementViewer
{
  private i r;
  protected Table e;
  protected Sheet f = null;
  private int s = 1;
  List g = new Vector();
  private List t;
  Thread q = null;
  private int u = 0;

  public M(SheetTable paramSheetTable, Composite paramComposite, bu parambu)
  {
    super(paramSheetTable, paramComposite, parambu);
  }

  protected aS e(Composite paramComposite)
  {
    return new M((SheetTable)this.c, paramComposite, this.a);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    g();
    return localComposite;
  }

  protected void h()
  {
    a(new W(this));
    a(new T(this));
    a(new V(this));
    a(new S(this));
    a(new U(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "refresh");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "search");
    a(paramToolBar, "import");
    a(paramToolBar, "export");
    a(paramToolBar, "presheet");
    a(paramToolBar, "nextsheet");
    super.a(paramToolBar);
  }

  protected void e()
  {
    f().setSheetData(null);
  }

  public void b(Composite paramComposite)
  {
    this.r = new i(true, true);
    this.e = this.r.a(paramComposite, 66304);
    this.e.setLayoutData(new GridData(1808));
    this.e.setHeaderVisible(true);
    this.e.setLinesVisible(true);
    this.e.addMouseListener(new N(this));
  }

  private void j()
  {
    this.o = 0;
    Q localQ = new Q(this);
    Display.getCurrent().timerExec(1, localQ);
  }

  private void b(Object[] paramArrayOfObject)
  {
    TableItem localTableItem = new TableItem(this.e, 0);
    localTableItem.setText(0, String.valueOf(this.s++));
    for (int i = 0; (i < paramArrayOfObject.length) && (i < this.t.size()); i++)
    {
      String str = null;
      SheetFieldModel localSheetFieldModel = (SheetFieldModel)this.t.get(i);
      if ((localSheetFieldModel.getJavaType().z()) || (localSheetFieldModel.getJavaType().m()))
        str = a(paramArrayOfObject[i]);
      else if (localSheetFieldModel.getJavaType().v())
        str = b(paramArrayOfObject[i]);
      else if (localSheetFieldModel.getJavaType().w())
        str = c(paramArrayOfObject[i]);
      else if (localSheetFieldModel.getJavaType().x())
        str = d(paramArrayOfObject[i]);
      else
        str = a(paramArrayOfObject[i]);
      if (str.length() > 30)
        localTableItem.setText(i + 1, str.substring(0, 30) + "...");
      else
        localTableItem.setText(i + 1, str);
    }
    localTableItem.setData(paramArrayOfObject);
    if ((this.m != null) && (!this.m.isDisposed()))
      this.m.setSelection(this.s);
    this.e.update();
    if (this.s > this.p)
      for (i = 0; i < this.e.getColumnCount(); i++)
        this.e.getColumn(i).pack();
  }

  protected void a(Object[] paramArrayOfObject)
  {
    this.g.add(paramArrayOfObject);
  }

  protected SheetTable f()
  {
    return (SheetTable)this.c;
  }

  public void g()
  {
    for (int i = this.e.getColumns().length; i > 0; i--)
      this.e.getColumn(i - 1).dispose();
    List localList = f().getFields();
    String[] arrayOfString1 = new String[localList.size() + 1];
    String[] arrayOfString2 = new String[localList.size() + 1];
    int[] arrayOfInt = new int[localList.size() + 1];
    arrayOfString1[0] = "";
    arrayOfString2[0] = "int";
    arrayOfInt[0] = 30;
    for (int j = 0; j < localList.size(); j++)
    {
      arrayOfString1[(j + 1)] = ((SheetFieldModel)localList.get(j)).getDisplayName();
      arrayOfString2[(j + 1)] = ((SheetFieldModel)localList.get(j)).getValueType();
      arrayOfInt[(j + 1)] = 80;
    }
    this.r.a(arrayOfString1, arrayOfInt, arrayOfString2);
  }

  protected boolean i()
  {
    try
    {
      if (f().getSheetData() != null)
        return !f().getSheetData().equals(this.f);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }

  public boolean needUpdate()
  {
    if (i())
      return true;
    return super.needUpdate();
  }

  private void k()
  {
    this.e.removeAll();
    Control[] arrayOfControl = this.e.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    this.t = f().getFields();
    if ((f() != null) && (this.g.size() == 0))
    {
      this.g.clear();
      this.q = new R(this);
      a(this.q, false);
      this.q.start();
      this.o = 0;
      j();
      z();
    }
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    g();
    if ((this.q != null) && (this.q.isAlive()))
      this.q.interrupt();
    k();
    super.update();
  }

  public String a(Object paramObject)
  {
    return I.a(paramObject);
  }

  public String b(Object paramObject)
  {
    if (paramObject == null)
      return "";
    if ((paramObject instanceof Date))
      return DateUtil.stringDate((Date)paramObject);
    return paramObject.toString();
  }

  public String c(Object paramObject)
  {
    if (paramObject == null)
      return "";
    if ((paramObject != null) && ((paramObject instanceof Date)))
      return DateUtil.stringTime((Date)paramObject);
    return paramObject.toString();
  }

  public String d(Object paramObject)
  {
    if (paramObject == null)
      return "";
    if ((paramObject != null) && ((paramObject instanceof Date)))
      return DateUtil.stringDatetime((Date)paramObject);
    return paramObject.toString();
  }

  public void dispose()
  {
    f().removeViewer(this);
    if (this.a != null)
      this.a.a(getCompositeUuid(), this.b);
  }

  public String getCompositeUuid()
  {
    return f().getEditUuid() + "data";
  }

  public void a(boolean paramBoolean)
  {
    this.o = 2;
  }

  public void find()
  {
    this.r.a();
  }

  public void findNext()
  {
    this.r.b();
  }

  public boolean isCanFind()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.M
 * JD-Core Version:    0.6.0
 */
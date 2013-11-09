package com.flagleader.builder.a.a;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.br;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.i;
import com.flagleader.db.IResult;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.I;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ISelectObject;
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

public abstract class a extends aS
  implements br, IElementViewer
{
  private i q;
  protected Table e;
  protected IResult f = null;
  private int r = 1;
  private Vector s = new Vector();
  private boolean t = false;
  private List u;
  Thread g = null;
  private boolean v = false;

  public a(ISelectObject paramISelectObject, Composite paramComposite, bu parambu)
  {
    super(paramISelectObject, paramComposite, parambu);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    b(localComposite);
    f();
    return localComposite;
  }

  protected void h()
  {
    a(new g(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "search");
    a(paramToolBar, "exportxls");
    super.a(paramToolBar);
  }

  public void b(Composite paramComposite)
  {
    this.q = new i(true, true);
    this.e = this.q.a(paramComposite, 66304);
    this.e.setLayoutData(new GridData(1808));
    this.e.setHeaderVisible(true);
    this.e.setLinesVisible(true);
    this.e.addMouseListener(new b(this));
  }

  protected void a(int paramInt)
  {
    int i = 0;
    while ((!this.s.isEmpty()) && (i < paramInt))
    {
      List localList = (List)this.s.remove(0);
      i++;
      TableItem localTableItem = new TableItem(this.e, 0);
      localTableItem.setText(0, String.valueOf(this.r++));
      for (int k = 0; k < localList.size(); k++)
      {
        String str = null;
        FieldModel localFieldModel = (FieldModel)this.u.get(k);
        if ((localFieldModel.getJavaType().z()) || (localFieldModel.getJavaType().m()))
          str = a(localList.get(k));
        else if (localFieldModel.getJavaType().v())
          str = b(localList.get(k));
        else if (localFieldModel.getJavaType().w())
          str = c(localList.get(k));
        else if (localFieldModel.getJavaType().x())
          str = d(localList.get(k));
        else
          str = a(localList.get(k));
        if (str.length() > 30)
          localTableItem.setText(k + 1, str.substring(0, 30) + "...");
        else
          localTableItem.setText(k + 1, str);
      }
      localTableItem.setData(localList);
    }
    this.v = false;
    if ((this.m != null) && (!this.m.isDisposed()))
      this.m.setSelection(this.r);
    this.e.update();
    if (this.r > this.p)
      for (int j = 0; j < this.e.getColumnCount(); j++)
        this.e.getColumn(j).pack();
  }

  protected void a(List paramList)
  {
    this.s.add(paramList);
  }

  protected ISelectObject e()
  {
    return (ISelectObject)this.c;
  }

  public void f()
  {
    for (int i = this.e.getColumns().length; i > 0; i--)
      this.e.getColumn(i - 1).dispose();
    List localList = e().getFields();
    String[] arrayOfString1 = new String[localList.size() + 1];
    String[] arrayOfString2 = new String[localList.size() + 1];
    int[] arrayOfInt = new int[localList.size() + 1];
    arrayOfString1[0] = "";
    arrayOfString2[0] = "int";
    arrayOfInt[0] = 30;
    for (int j = 0; j < localList.size(); j++)
    {
      arrayOfString1[(j + 1)] = ((FieldModel)localList.get(j)).getDisplayName();
      arrayOfString2[(j + 1)] = ((FieldModel)localList.get(j)).getValueType();
      arrayOfInt[(j + 1)] = 80;
    }
    this.q.a(arrayOfString1, arrayOfInt, arrayOfString2);
  }

  protected boolean g()
  {
    return true;
  }

  public void update()
  {
    if ((this.b == null) || (this.b.isDisposed()) || ((this.a != null) && (!equals(this.a.e()))))
      return;
    if (!g())
      return;
    f();
    if ((this.g != null) && (this.g.isAlive()))
      this.g.interrupt();
    this.s.clear();
    this.e.removeAll();
    Control[] arrayOfControl = this.e.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    this.u = e().getFields();
    if (e().getDBModel() != null)
    {
      this.t = false;
      Display localDisplay = this.e.getDisplay();
      e locale = new e(this);
      localDisplay.timerExec(100, locale);
      this.g = new f(this);
      a(this.g, false);
      this.g.start();
    }
    super.update();
  }

  protected abstract IResult i();

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
    e().removeViewer(this);
    if (this.a != null)
      this.a.a(getCompositeUuid(), this.b);
  }

  public String getCompositeUuid()
  {
    return e().getEditUuid() + "data";
  }

  public boolean j()
  {
    return this.t;
  }

  public void a(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }

  public void find()
  {
    this.q.a();
  }

  public void findNext()
  {
    this.q.b();
  }

  public boolean isCanFind()
  {
    return true;
  }

  protected aS e(Composite paramComposite)
  {
    return null;
  }

  protected void B()
  {
    this.s.clear();
    this.t = true;
    super.B();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.a.a
 * JD-Core Version:    0.6.0
 */
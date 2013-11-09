package com.flagleader.builder.a.d;

import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.widget.p;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public abstract class a extends aS
{
  protected Table e;
  private TableEditor f;
  private Text g;
  private CCombo q;

  public a(ITreeNode paramITreeNode, Composite paramComposite, bu parambu)
  {
    super(paramITreeNode, paramComposite, parambu);
  }

  protected void h()
  {
    a(new n(this));
    a(new m(this));
    super.h();
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "moveUp");
    a(paramToolBar, "moveDown");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "cut");
    a(paramToolBar, "copy");
    a(paramToolBar, "paste");
    a(paramToolBar, "delete");
    a(paramToolBar, "selectall");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "search");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    Table localTable = b(localComposite);
    localTable.setData(this.c);
    return localComposite;
  }

  public void update()
  {
    if (!e())
      return;
    this.e.removeAll();
    Control[] arrayOfControl = this.e.getChildren();
    for (int i = 0; i < arrayOfControl.length; i++)
      arrayOfControl[i].dispose();
    this.e.update();
    p();
    super.update();
  }

  protected boolean e()
  {
    return (this.b != null) && (!this.b.isDisposed()) && ((this.a == null) || (equals(this.a.e())));
  }

  private void c(IElement paramIElement)
  {
    for (int i = 0; i < this.e.getItems().length; i++)
    {
      if (this.e.getItems()[i].getData() != paramIElement)
        continue;
      this.e.setSelection(new TableItem[] { this.e.getItem(i) });
      return;
    }
  }

  protected int f()
  {
    return this.e.getSelectionCount();
  }

  protected IElement[] g()
  {
    if (this.e.getSelectionCount() > 0)
    {
      IElement[] arrayOfIElement = new IElement[this.e.getSelectionCount()];
      TableItem[] arrayOfTableItem = this.e.getSelection();
      for (int i = 0; i < arrayOfTableItem.length; i++)
      {
        if ((arrayOfTableItem[i].getData() == null) || (!(arrayOfTableItem[i].getData() instanceof IElement)))
          continue;
        arrayOfIElement[i] = ((IElement)arrayOfTableItem[i].getData());
      }
      return arrayOfIElement;
    }
    return null;
  }

  protected Item[] i()
  {
    return this.e.getSelection();
  }

  protected abstract String[] j();

  protected abstract String[] k();

  protected boolean l()
  {
    return false;
  }

  protected boolean a(IElement paramIElement, boolean paramBoolean)
  {
    return true;
  }

  protected void a(TableItem paramTableItem, int paramInt)
  {
    if ((paramTableItem.getData() == null) || (!(paramTableItem.getData() instanceof IElement)))
      return;
    com.flagleader.builder.a.c.c localc = a((IElement)paramTableItem.getData(), paramInt, false);
    if (localc != null)
      if ((localc instanceof com.flagleader.builder.a.c.f))
        a(paramTableItem, paramInt, (com.flagleader.builder.a.c.f)localc);
      else if ((localc instanceof com.flagleader.builder.a.c.e))
        a(paramTableItem, paramInt, (com.flagleader.builder.a.c.e)localc);
      else if ((localc instanceof com.flagleader.builder.a.c.d))
        a(paramTableItem, paramInt, (com.flagleader.builder.a.c.d)localc);
  }

  protected boolean m()
  {
    return false;
  }

  protected void a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.keyCode == 16777217) && ((paramKeyEvent.stateMask & SWT.MOD3) != 0) && (this.e.getSelectionCount() == 1))
    {
      a(g()[0]);
      paramKeyEvent.doit = false;
    }
    if ((paramKeyEvent.keyCode == 16777218) && ((paramKeyEvent.stateMask & SWT.MOD3) != 0) && (this.e.getSelectionCount() == 1))
    {
      b(g()[0]);
      paramKeyEvent.doit = false;
    }
    super.a(paramKeyEvent);
  }

  protected void n()
  {
    while (this.e.getColumnCount() > 0)
      this.e.getColumn(0).dispose();
    String[] arrayOfString1 = j();
    String[] arrayOfString2 = k();
    int i = arrayOfString1.length;
    for (int j = 0; j < i; j++)
    {
      TableColumn localTableColumn = new TableColumn(this.e, 0);
      localTableColumn.setWidth(Integer.parseInt(arrayOfString2[j]));
      localTableColumn.setText(arrayOfString1[j]);
      int k = j;
      if (!m())
        continue;
      localTableColumn.addSelectionListener(new b(this, localTableColumn, k));
    }
  }

  protected com.flagleader.builder.a.c.c a(IElement paramIElement, int paramInt, boolean paramBoolean)
  {
    return null;
  }

  protected Table b(Composite paramComposite)
  {
    int i = 68354;
    if (l())
      i |= 32;
    this.e = new Table(paramComposite, i);
    this.e.setLinesVisible(true);
    this.e.setHeaderVisible(true);
    this.e.setLayoutData(new GridData(1808));
    n();
    this.f = new TableEditor(this.e);
    if (!this.c.isLocked())
    {
      this.e.addMouseListener(new e(this));
      this.e.addMouseMoveListener(new f(this));
      this.e.addKeyListener(new g(this));
      if (l())
        this.e.addSelectionListener(new h(this));
    }
    return this.e;
  }

  protected boolean a(Menu paramMenu, Item[] paramArrayOfItem)
  {
    a(paramMenu, "update");
    return true;
  }

  protected void a(TableItem paramTableItem, int paramInt, com.flagleader.builder.a.c.f paramf)
  {
    if ((paramTableItem == null) || (paramTableItem.isDisposed()))
      return;
    this.g = new p(a()).a(this.e, 4);
    this.g.setFont(this.e.getFont());
    this.g.setText(paramTableItem.getText(paramInt));
    this.g.selectAll();
    this.f.horizontalAlignment = 16384;
    this.f.grabHorizontal = true;
    this.f.setEditor(this.g, paramTableItem, paramInt);
    this.g.addFocusListener(new i(this, paramf, paramTableItem));
    this.g.addTraverseListener(new j(this, paramf, paramTableItem));
    this.g.setFocus();
  }

  private void a(TableItem paramTableItem, int paramInt, com.flagleader.builder.a.c.e parame)
  {
    this.q = new CCombo(this.e, 8);
    this.q.setItems(parame.a());
    this.q.setText(paramTableItem.getText(paramInt));
    if (this.q.getItemCount() < 20)
      this.q.setVisibleItemCount(this.q.getItemCount());
    else
      this.q.setVisibleItemCount(20);
    this.f.horizontalAlignment = 16384;
    this.f.grabHorizontal = true;
    this.f.minimumWidth = 50;
    this.f.setEditor(this.q, paramTableItem, paramInt);
    this.q.addFocusListener(new k(this, parame, paramTableItem));
    this.q.addTraverseListener(new l(this, parame, paramTableItem));
    this.q.setFocus();
  }

  private void a(TableItem paramTableItem, int paramInt, com.flagleader.builder.a.c.d paramd)
  {
    this.q = new CCombo(this.e, 8);
    this.q.setItems(paramd.a());
    this.q.setText(paramTableItem.getText(paramInt));
    if (this.q.getItemCount() < 20)
      this.q.setVisibleItemCount(this.q.getItemCount());
    else
      this.q.setVisibleItemCount(20);
    this.f.horizontalAlignment = 16384;
    this.f.grabHorizontal = true;
    this.f.minimumWidth = 50;
    this.f.setEditor(this.q, paramTableItem, paramInt);
    this.q.addFocusListener(new c(this, paramd, paramTableItem));
    this.q.addTraverseListener(new d(this, paramd, paramTableItem));
    this.q.setFocus();
  }

  protected void o()
  {
    this.f.setEditor(null, null, -1);
    if (this.g != null)
    {
      this.g.dispose();
      this.g = null;
    }
    if ((this.q != null) && (!this.q.isDisposed()))
    {
      this.q.dispose();
      this.q = null;
    }
  }

  protected void a(Item paramItem)
  {
    paramItem.dispose();
  }

  protected void b(Item paramItem)
  {
  }

  protected void c(Item paramItem)
  {
    TableItem localTableItem = (TableItem)paramItem;
    a(localTableItem, (IElement)localTableItem.getData());
  }

  protected abstract void p();

  protected Item d(Item paramItem)
  {
    if (paramItem == null)
      return new TableItem(this.e, 0);
    return new TableItem(this.e, 0);
  }

  protected void a(Item paramItem, Color paramColor)
  {
    ((TableItem)paramItem).setBackground(paramColor);
  }

  protected void a(Item paramItem, boolean paramBoolean, String[] paramArrayOfString)
  {
    TableItem localTableItem = (TableItem)paramItem;
    for (int i = 0; (paramArrayOfString != null) && (i < paramArrayOfString.length); i++)
      localTableItem.setText(i, paramArrayOfString[i]);
    if (l())
      localTableItem.setChecked(paramBoolean);
  }

  protected abstract void a(Item paramItem, IElement paramIElement);

  protected boolean a(IElement paramIElement)
  {
    if (b())
      return false;
    IElement localIElement = paramIElement.getParent();
    int i = localIElement.getElementPos(paramIElement);
    if (i >= 1)
    {
      localIElement.moveElement(i, i - 1);
      this.c.setModified(true);
      update();
    }
    c(paramIElement);
    return true;
  }

  protected boolean b(IElement paramIElement)
  {
    if (b())
      return false;
    IElement localIElement = paramIElement.getParent();
    int i = localIElement.getElementPos(paramIElement);
    localIElement.moveElement(i, i + 1);
    this.c.setModified(true);
    update();
    c(paramIElement);
    return true;
  }

  public boolean canCopy()
  {
    return (this.e.isFocusControl()) && (this.e.getSelection().length > 0);
  }

  public boolean canCut()
  {
    if (b())
      return false;
    return (this.e.isFocusControl()) && (this.e.getSelection().length > 0);
  }

  public boolean canDelete()
  {
    if (b())
      return false;
    return (this.e.isFocusControl()) && (this.e.getSelection().length > 0);
  }

  public void selectAll()
  {
    this.e.setSelection(this.e.getItems());
    setChanged();
    notifyObservers();
  }

  public boolean isCanSelectAll()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.a
 * JD-Core Version:    0.6.0
 */
package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.aS;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.a.c.c;
import com.flagleader.builder.a.c.d;
import com.flagleader.builder.a.c.e;
import com.flagleader.builder.a.c.f;
import com.flagleader.manager.a;
import com.flagleader.manager.d.b;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

public abstract class o extends aS
{
  protected Tree e;
  protected com.flagleader.builder.widget.s f;
  private TreeEditor q;
  TreeItem g;
  private Text r;
  private CCombo s;

  public o(ITreeNode paramITreeNode, Composite paramComposite, bu parambu)
  {
    super(paramITreeNode, paramComposite, parambu);
  }

  protected void h()
  {
    a(new B(this));
    a(new A(this));
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
    Tree localTree = b(localComposite);
    localTree.setData(this.c);
    return localComposite;
  }

  public void update()
  {
    if (!e())
      return;
    n();
    this.e.removeAll();
    this.e.update();
    p();
    if ((!this.c.isLocked()) && (a().getConfigManager().E()))
      a().getRulesManager().c().a(this.c);
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
      if (this.e.getItems()[i].getData() == paramIElement)
      {
        this.e.setSelection(new TreeItem[] { this.e.getItem(i) });
        return;
      }
      if (this.e.getItems()[i].getItemCount() <= 0)
        continue;
      for (int j = 0; j < this.e.getItems()[i].getItemCount(); j++)
      {
        if (this.e.getItem(i).getItem(j).getData() != paramIElement)
          continue;
        this.e.setSelection(new TreeItem[] { this.e.getItem(i).getItem(j) });
        return;
      }
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
      TreeItem[] arrayOfTreeItem = this.e.getSelection();
      for (int i = 0; i < arrayOfTreeItem.length; i++)
      {
        if ((arrayOfTreeItem[i].getData() == null) || (!(arrayOfTreeItem[i].getData() instanceof IElement)))
          continue;
        arrayOfIElement[i] = ((IElement)arrayOfTreeItem[i].getData());
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

  protected void a(TreeItem paramTreeItem, int paramInt)
  {
    if ((paramTreeItem.getData() == null) || (!(paramTreeItem.getData() instanceof IElement)))
      return;
    c localc = a((IElement)paramTreeItem.getData(), paramInt, false);
    if (localc != null)
      if ((localc instanceof f))
        a(paramTreeItem, paramInt, (f)localc);
      else if ((localc instanceof e))
        a(paramTreeItem, paramInt, (e)localc);
      else if ((localc instanceof d))
        a(paramTreeItem, paramInt, (d)localc);
  }

  protected boolean m()
  {
    return false;
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
      TreeColumn localTreeColumn = new TreeColumn(this.e, 0);
      localTreeColumn.setWidth(Integer.parseInt(arrayOfString2[j]));
      localTreeColumn.setText(arrayOfString1[j]);
      int k = j;
      if (!m())
        continue;
      localTreeColumn.addSelectionListener(new p(this, localTreeColumn, k));
    }
  }

  protected c a(IElement paramIElement, int paramInt, boolean paramBoolean)
  {
    return null;
  }

  protected Tree b(Composite paramComposite)
  {
    int i = 68354;
    if (l())
      i |= 32;
    this.f = new com.flagleader.builder.widget.s();
    this.e = this.f.a(paramComposite, i);
    this.e.setLinesVisible(true);
    this.e.setHeaderVisible(true);
    this.e.setLayoutData(new GridData(1808));
    this.q = new TreeEditor(this.e);
    if (!this.c.isLocked())
    {
      this.e.addMouseListener(new s(this));
      this.e.addMouseMoveListener(new t(this));
      this.e.addKeyListener(new u(this));
      if (l())
        this.e.addSelectionListener(new v(this));
    }
    return this.e;
  }

  protected boolean a(Menu paramMenu, Item[] paramArrayOfItem)
  {
    a(paramMenu, "update");
    return true;
  }

  protected void a(TreeItem paramTreeItem, int paramInt, f paramf)
  {
    if ((paramTreeItem == null) || (paramTreeItem.isDisposed()))
      return;
    this.q.horizontalAlignment = 16384;
    this.q.grabHorizontal = true;
    this.r = new com.flagleader.builder.widget.p(a()).a(this.e, 4);
    this.r.setFont(this.e.getFont());
    this.r.setText(paramTreeItem.getText(paramInt));
    this.r.selectAll();
    this.q.setEditor(this.r, paramTreeItem, paramInt);
    this.r.addFocusListener(new w(this, paramf, paramTreeItem));
    this.r.addTraverseListener(new x(this, paramf, paramTreeItem));
    this.r.setFocus();
  }

  private void a(TreeItem paramTreeItem, int paramInt, e parame)
  {
    if (this.q == null)
      return;
    this.q.horizontalAlignment = 16384;
    this.q.grabHorizontal = true;
    this.q.minimumWidth = 50;
    this.s = new CCombo(this.e, 2048);
    this.s.setItems(parame.a());
    this.s.setText(paramTreeItem.getText(paramInt));
    if (this.s.getItemCount() < 20)
      this.s.setVisibleItemCount(this.s.getItemCount());
    else
      this.s.setVisibleItemCount(20);
    this.q.setEditor(this.s, paramTreeItem, paramInt);
    this.s.addFocusListener(new y(this, parame, paramTreeItem));
    this.s.addTraverseListener(new z(this, parame, paramTreeItem));
    this.s.setFocus();
  }

  private void a(TreeItem paramTreeItem, int paramInt, d paramd)
  {
    if (this.q == null)
      return;
    this.q.horizontalAlignment = 16384;
    this.q.grabHorizontal = true;
    this.q.minimumWidth = 50;
    this.s = new CCombo(this.e, 8);
    this.s.setItems(paramd.a());
    this.s.setText(paramTreeItem.getText(paramInt));
    if (this.s.getItemCount() < 20)
      this.s.setVisibleItemCount(this.s.getItemCount());
    else
      this.s.setVisibleItemCount(20);
    this.q.setEditor(this.s, paramTreeItem, paramInt);
    this.s.addFocusListener(new q(this, paramd, paramTreeItem));
    this.s.addTraverseListener(new r(this, paramd, paramTreeItem));
    this.s.setFocus();
  }

  protected void o()
  {
    if (this.r != null)
    {
      this.r.dispose();
      this.r = null;
    }
    if ((this.s != null) && (!this.s.isDisposed()))
    {
      this.s.dispose();
      this.s = null;
    }
    this.q.setEditor(null, null, -1);
  }

  protected void a(Item paramItem)
  {
    paramItem.dispose();
  }

  protected void b(Item paramItem)
  {
    ((TreeItem)paramItem).setExpanded(true);
  }

  protected void c(Item paramItem)
  {
    TreeItem localTreeItem = (TreeItem)paramItem;
    while ((!localTreeItem.isDisposed()) && (localTreeItem.getItemCount() > 0))
      localTreeItem.getItems()[0].dispose();
    a(localTreeItem, (IElement)localTreeItem.getData());
    localTreeItem.setExpanded(true);
  }

  protected abstract void p();

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

  protected Item d(Item paramItem)
  {
    if (paramItem == null)
      return new TreeItem(this.e, 0);
    return new TreeItem((TreeItem)paramItem, 0);
  }

  protected void a(Item paramItem, Color paramColor)
  {
    ((TreeItem)paramItem).setBackground(paramColor);
  }

  protected void a(Item paramItem, boolean paramBoolean, String[] paramArrayOfString)
  {
    TreeItem localTreeItem = (TreeItem)paramItem;
    for (int i = 0; (paramArrayOfString != null) && (i < paramArrayOfString.length); i++)
      localTreeItem.setText(i, paramArrayOfString[i]);
    if (l())
      localTreeItem.setChecked(paramBoolean);
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

  public void find()
  {
    this.f.a();
  }

  public void findNext()
  {
    this.f.b();
  }

  public boolean isCanFind()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.o
 * JD-Core Version:    0.6.0
 */
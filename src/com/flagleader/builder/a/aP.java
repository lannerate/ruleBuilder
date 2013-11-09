package com.flagleader.builder.a;

import com.flagleader.builder.widget.editor.p;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public abstract class aP extends aS
  implements bq
{
  protected p e;

  public aP(ITreeNode paramITreeNode, Composite paramComposite, bu parambu)
  {
    super(paramITreeNode, paramComposite, parambu);
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = (Composite)super.a(paramComposite);
    this.e = b(localComposite);
    if (!b())
      this.e.a().addFocusListener(new aQ(this));
    else
      this.e.a().setEditable(false);
    return localComposite;
  }

  protected abstract p b(Composite paramComposite);

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "undo");
    a(paramToolBar, "redo");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "cut");
    a(paramToolBar, "copy");
    a(paramToolBar, "paste");
    a(paramToolBar, "delete");
    a(paramToolBar, "selectall");
    new ToolItem(paramToolBar, 2);
    a(paramToolBar, "search");
    a(paramToolBar, "next");
    new ToolItem(paramToolBar, 2);
    super.a(paramToolBar);
  }

  protected abstract void a(String paramString);

  public void d()
  {
    if (this.e != null)
      this.e.d();
  }

  public void a(Printer paramPrinter)
  {
    if (this.e != null)
      this.e.a(paramPrinter);
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canCut()
  {
    return !b();
  }

  public boolean canDelete()
  {
    return !b();
  }

  public boolean canPaste()
  {
    return !b();
  }

  public boolean c()
  {
    return this.e.v();
  }

  public boolean canRedo()
  {
    return this.e.g();
  }

  public boolean canUndo()
  {
    return this.e.f();
  }

  public void copy()
  {
    this.e.w();
  }

  public void cut()
  {
    if (!b())
      this.e.x();
  }

  public void delete()
  {
    if (!b())
      this.e.y();
  }

  public void find()
  {
    this.e.A();
  }

  public boolean isCanFind()
  {
    return true;
  }

  public boolean isCanSelectAll()
  {
    return true;
  }

  public boolean paste()
  {
    if (!b())
      this.e.D();
    return true;
  }

  public boolean redo()
  {
    if (!b())
      return this.e.e();
    return false;
  }

  public void selectAll()
  {
    this.e.E();
  }

  public boolean undo()
  {
    if (!b())
      return this.e.c();
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aP
 * JD-Core Version:    0.6.0
 */
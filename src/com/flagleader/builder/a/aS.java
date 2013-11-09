package com.flagleader.builder.a;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.a.c.b;
import com.flagleader.builder.shell.J;
import com.flagleader.repository.tree.ITreeNode;
import java.util.HashMap;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public abstract class aS extends a
{
  protected Control h;
  protected Control i;
  protected Composite j;
  protected ToolBar k;
  protected HashMap l = new HashMap();
  protected ProgressBar m = null;
  protected Button n = null;
  protected int o = -1;
  protected int p = 10;
  private boolean e = true;
  private Runnable f;

  public aS(ITreeNode paramITreeNode, Composite paramComposite, bu parambu)
  {
    super(paramITreeNode, paramComposite, parambu);
    h();
    c(paramComposite);
  }

  public String getCompositeUuid()
  {
    return this.c.getEditUuid();
  }

  protected void a(b paramb)
  {
    this.l.put(paramb.c(), paramb);
  }

  protected void a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.keyCode == 127) && (canDelete()))
    {
      delete();
      paramKeyEvent.doit = false;
    }
    if ((paramKeyEvent.keyCode == 16777228) && (isCanFind()))
    {
      findNext();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 65) || (paramKeyEvent.keyCode == 97)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0) && (isCanSelectAll()))
    {
      selectAll();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 70) || (paramKeyEvent.keyCode == 102)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0) && (isCanFind()))
    {
      find();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 67) || (paramKeyEvent.keyCode == 99)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0) && (canCopy()))
    {
      copy();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 86) || (paramKeyEvent.keyCode == 118)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0) && (canPaste()))
    {
      paste();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 88) || (paramKeyEvent.keyCode == 120)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0) && (canCut()))
    {
      cut();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 90) || (paramKeyEvent.keyCode == 122)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0) && (canUndo()))
    {
      undo();
      paramKeyEvent.doit = false;
    }
    if (((paramKeyEvent.keyCode == 89) || (paramKeyEvent.keyCode == 121)) && ((paramKeyEvent.stateMask & SWT.MOD1) != 0) && (canRedo()))
    {
      redo();
      paramKeyEvent.doit = false;
    }
  }

  protected void h()
  {
    a(new bj(this));
    a(new bi(this));
    a(new bk(this));
    a(new bh(this));
    a(new bf(this));
    a(new bl(this));
    a(new bd(this));
    a(new bc(this));
    a(new be(this));
    a(new bg(this));
    a(new bm(this));
  }

  protected Control c(Composite paramComposite)
  {
    this.i = d(paramComposite);
    this.h = a(paramComposite);
    return paramComposite;
  }

  protected Control a(Composite paramComposite)
  {
    Composite localComposite = new Composite(paramComposite, 0);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localComposite.setLayout(localGridLayout);
    localComposite.setLayoutData(new GridData(1808));
    localComposite.setFont(paramComposite.getFont());
    return localComposite;
  }

  protected synchronized void setChanged()
  {
    z();
    super.setChanged();
  }

  protected Control d(Composite paramComposite)
  {
    Composite localComposite1 = new Composite(paramComposite, 0);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.numColumns = 2;
    localComposite1.setLayout(localGridLayout);
    localComposite1.setLayoutData(new GridData(4, 16777216, true, false));
    localComposite1.setFont(paramComposite.getFont());
    Composite localComposite2 = new Composite(localComposite1, 0);
    GridData localGridData = new GridData(4, 16777216, true, false);
    localGridData.heightHint = 20;
    localGridLayout = new GridLayout();
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.numColumns = 1;
    localComposite2.setLayout(localGridLayout);
    localComposite2.setLayoutData(localGridData);
    this.k = new ToolBar(localComposite2, 256);
    a(this.k);
    this.j = new Composite(localComposite1, 0);
    localGridLayout = new GridLayout();
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.numColumns = 10;
    this.j.setLayout(localGridLayout);
    localGridData = new GridData(131072, 16777216, true, false);
    localGridData.widthHint = 150;
    localGridData.heightHint = 20;
    this.j.setLayoutData(localGridData);
    this.j.setFont(paramComposite.getFont());
    return localComposite1;
  }

  protected void z()
  {
    if ((this.f != null) && (this.e))
    {
      this.e = false;
      Display.getCurrent().timerExec(500, this.f);
    }
  }

  protected abstract aS e(Composite paramComposite);

  protected void A()
  {
    if ((this.a != null) && (this.b != null) && ((this.b.getParent() instanceof CTabFolder)))
    {
      Shell localShell = new Shell();
      Composite localComposite = new J(((CTabFolder)this.b.getParent()).getSelection().getText(), new aT(this)).b(localShell.getDisplay());
    }
  }

  protected void a(ToolBar paramToolBar)
  {
    a(paramToolBar, "window");
    a(paramToolBar, "update");
    this.f = new aU(this);
    z();
  }

  protected ToolItem a(ToolBar paramToolBar, String paramString)
  {
    b localb = b(paramString);
    if (localb != null)
    {
      ToolItem localToolItem;
      if (localb.g() == 2)
      {
        localToolItem = new ToolItem(paramToolBar, 2);
        localToolItem.setToolTipText("SWT.SEPARATOR");
        Combo localCombo = new Combo(paramToolBar, 8);
        localCombo.setItems(localb.i());
        localCombo.setText(localb.j());
        localCombo.pack();
        localToolItem.setWidth(localCombo.getSize().x);
        localToolItem.setControl(localCombo);
        localCombo.addSelectionListener(new aV(this, localb, localCombo));
      }
      else
      {
        if (localb.g() == 1)
        {
          localToolItem = new ToolItem(paramToolBar, 32);
          localToolItem.setImage(ResourceTools.getImage(localb.d()));
          localToolItem.setToolTipText(localb.f());
          localToolItem.addSelectionListener(new aW(this, localb, localToolItem));
          localToolItem.setData(localb);
          return localToolItem;
        }
        localToolItem = new ToolItem(paramToolBar, 8);
        localToolItem.setImage(ResourceTools.getImage(localb.d()));
        localToolItem.setToolTipText(localb.f());
        localToolItem.addSelectionListener(new aX(this, localb));
        localToolItem.setData(localb);
        return localToolItem;
      }
    }
    return null;
  }

  protected b b(String paramString)
  {
    return (b)this.l.get(paramString);
  }

  protected MenuItem a(Menu paramMenu, String paramString)
  {
    b localb = b(paramString);
    if ((localb != null) && (localb.b()))
    {
      MenuItem localMenuItem = new MenuItem(paramMenu, 8);
      localMenuItem.setText(localb.e());
      localMenuItem.addListener(13, new aY(this, localb));
      return localMenuItem;
    }
    return null;
  }

  public void a(Thread paramThread, boolean paramBoolean)
  {
    a(paramThread, paramBoolean, paramBoolean);
  }

  protected void B()
  {
  }

  public void a(Thread paramThread, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.m == null) || (this.m.isDisposed()))
    {
      if (paramBoolean1)
        this.m = new ProgressBar(this.j, 258);
      else
        this.m = new ProgressBar(this.j, 256);
      this.m.setLayoutData(new GridData(130, 16));
      this.n = new Button(this.j, 8);
      this.n.setImage(ResourceTools.getImage("stop.icon"));
      this.n.addSelectionListener(new aZ(this, paramThread, paramBoolean2));
      this.n.setLayoutData(new GridData(16, 16));
      this.j.setSize(this.j.computeSize(-1, -1));
      this.j.redraw();
    }
  }

  public void C()
  {
    this.j.getDisplay().asyncExec(new ba(this));
  }

  public void b(int paramInt)
  {
    if ((this.j != null) && (!this.j.isDisposed()))
      this.j.getDisplay().asyncExec(new bb(this, paramInt));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.aS
 * JD-Core Version:    0.6.0
 */
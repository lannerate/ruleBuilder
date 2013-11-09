package com.flagleader.builder.actions;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.h;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class bm
{
  private BuilderManager a;
  private Composite b;
  private Composite c;
  private Composite d;
  private Composite e;
  private Composite f;
  private CTabFolder g;
  private CTabFolder h;
  private SashForm i;
  private SashForm j;
  private boolean k = true;
  private boolean l = true;
  private boolean m = true;
  private boolean n = true;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;

  public bm(BuilderManager paramBuilderManager)
  {
    this.a = paramBuilderManager;
  }

  private void b(Composite paramComposite)
  {
    ((aO)this.a.getProjectTree()).a(paramComposite);
  }

  private void a(Composite paramComposite, String paramString)
  {
    Label localLabel = new Label(paramComposite, 0);
    localLabel.setImage(ResourceTools.getImage("close.icon"));
    localLabel.setBackground(h.c);
    localLabel.addMouseListener(new bn(this, paramString));
  }

  public void a()
  {
    this.c.setVisible(j());
    this.d.setVisible(g());
    this.f.setVisible(i());
    this.e.setVisible(h());
    if (i())
    {
      if (g())
        this.j.setWeights(new int[] { 80, 20 });
      else
        this.j.setWeights(new int[] { 0, 100 });
    }
    else if (g())
      this.j.setWeights(new int[] { 100 });
    if (j())
    {
      if ((g()) || (i()))
      {
        if (h())
          this.i.setWeights(new int[] { 15, 70, 15 });
        else
          this.i.setWeights(new int[] { 15, 85 });
      }
      else if (h())
        this.i.setWeights(new int[] { 15, 0, 85 });
      else
        this.i.setWeights(new int[] { 100 });
    }
    else if ((g()) || (i()))
    {
      if (h())
        this.i.setWeights(new int[] { 0, 85, 15 });
      else
        this.i.setWeights(new int[] { 0, 100 });
    }
    else if (h())
      this.i.setWeights(new int[] { 0, 0, 100 });
    else
      this.i.setWeights(new int[3]);
    this.i.redraw();
    this.j.redraw();
  }

  public void b()
  {
    d(false);
    a();
  }

  public void c()
  {
    a(false);
    a();
  }

  public void d()
  {
    c(false);
    a();
  }

  private Label b(Composite paramComposite, String paramString)
  {
    Label localLabel = new Label(paramComposite, 33554432);
    localLabel.setText(ResourceTools.getMessage(paramString, paramString));
    localLabel.setBackground(h.c);
    localLabel.setForeground(h.f);
    localLabel.setLayoutData(new GridData(1808));
    return localLabel;
  }

  private Label c(Composite paramComposite, String paramString)
  {
    Composite localComposite = new Composite(paramComposite, 67108864);
    localComposite.setBackground(h.c);
    localComposite.setLayout(h.a(2));
    localComposite.setLayoutData(h.a(0, 16, 768));
    a(localComposite, paramString);
    return b(localComposite, paramString);
  }

  private void c(Composite paramComposite)
  {
    this.c = new Composite(paramComposite, 2048);
    this.c.setLayout(h.a(1));
    this.c.setLayoutData(new GridData(1808));
    this.g = new CTabFolder(this.c, 8389504);
    this.g.setLayout(h.a(1));
    this.g.setLayoutData(new GridData(1808));
    this.g.setMinimizeVisible(true);
    this.g.setMaximizeVisible(true);
    this.g.addCTabFolder2Listener(new bo(this));
    this.g.addMouseListener(new bp(this));
    CTabItem localCTabItem = new CTabItem(this.g, 0);
    localCTabItem.setText(ResourceTools.getMessage("project_view"));
    Composite localComposite = new Composite(this.g, 8388608);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    b(localComposite);
    localCTabItem.setControl(localComposite);
    this.g.setSelection(0);
  }

  private void d(Composite paramComposite)
  {
    this.d = new Composite(paramComposite, 2048);
    this.d.setLayout(h.a(1));
    this.d.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder = new CTabFolder(this.d, 8389504);
    localCTabFolder.setLayout(h.a(1));
    localCTabFolder.setLayoutData(new GridData(1808));
    localCTabFolder.setMinimizeVisible(true);
    localCTabFolder.setMaximizeVisible(true);
    localCTabFolder.addCTabFolder2Listener(new bq(this, localCTabFolder));
    localCTabFolder.addMouseListener(new br(this, localCTabFolder));
    this.a.getRuleEditor().a(localCTabFolder);
  }

  private void e(Composite paramComposite)
  {
    this.e = new Composite(paramComposite, 2048);
    this.e.setLayout(h.a(1));
    this.e.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder = new CTabFolder(this.e, 8389504);
    localCTabFolder.setLayout(h.a(1));
    localCTabFolder.setLayoutData(new GridData(1808));
    localCTabFolder.setMinimizeVisible(true);
    localCTabFolder.setMaximizeVisible(true);
    localCTabFolder.addCTabFolder2Listener(new bs(this, localCTabFolder));
    localCTabFolder.addMouseListener(new bt(this, localCTabFolder));
    this.a.getRuleEditor().b(localCTabFolder);
  }

  private void f(Composite paramComposite)
  {
    this.f = new Composite(paramComposite, 2048);
    this.f.setLayout(h.a(1));
    this.f.setLayoutData(new GridData(1808));
    this.h = new CTabFolder(this.f, 8389504);
    this.h.setLayout(h.a(1));
    this.h.setLayoutData(new GridData(1808));
    this.h.setMinimizeVisible(true);
    this.h.setMaximizeVisible(true);
    this.h.addCTabFolder2Listener(new bu(this));
    this.h.addMouseListener(new bv(this));
    this.a.getMessageWindow().a(this.h);
    this.h.setSelection(0);
  }

  public CTabFolder e()
  {
    return this.h;
  }

  public Composite a(Composite paramComposite)
  {
    this.i = new SashForm(paramComposite, 256);
    this.i.setLayout(new FillLayout());
    c(this.i);
    g(this.i);
    e(this.i);
    this.i.setWeights(new int[] { 15, 70, 15 });
    this.b = this.i;
    return this.i;
  }

  private Composite g(Composite paramComposite)
  {
    this.j = new SashForm(paramComposite, 512);
    this.j.setLayout(new FillLayout());
    h(this.j);
    f(this.j);
    this.j.setWeights(new int[] { 80, 20 });
    this.b = this.j;
    return this.j;
  }

  private void h(Composite paramComposite)
  {
    d(paramComposite);
  }

  public void f()
  {
    if ((this.b != null) && (!this.b.isDisposed()))
      this.b.dispose();
  }

  private Composite k()
  {
    return this.d;
  }

  public boolean g()
  {
    return this.m;
  }

  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public boolean h()
  {
    return this.n;
  }

  public void b(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }

  public boolean i()
  {
    return this.k;
  }

  public void c(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public boolean j()
  {
    return this.l;
  }

  public void d(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.bm
 * JD-Core Version:    0.6.0
 */
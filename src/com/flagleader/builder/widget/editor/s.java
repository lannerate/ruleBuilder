package com.flagleader.builder.widget.editor;

import com.flagleader.builder.BuilderConfig;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.k;
import com.flagleader.builder.widget.editor.a.f;
import com.flagleader.builder.widget.h;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class s
  implements p, IPropertyChangeListener
{
  protected i j;
  private SourceViewer m;
  private j n = new j(this);
  private PreferenceStore o;
  private IUndoManager p;
  private g q;
  protected o k = new q();
  protected com.flagleader.manager.c.a l;
  private String r = "";
  private Menu s = null;
  private n t;

  public s()
  {
    this.l = new com.flagleader.manager.c.d();
  }

  public s(com.flagleader.manager.c.a parama)
  {
    if (parama != null)
      this.l = parama;
    else
      this.l = new com.flagleader.manager.c.d();
  }

  public static p a(int paramInt1, com.flagleader.manager.c.a parama, Composite paramComposite, int paramInt2)
  {
    return a(paramInt1, parama, paramComposite, paramInt2, new c());
  }

  public static p a(int paramInt1, com.flagleader.manager.c.a parama, Composite paramComposite, int paramInt2, n paramn)
  {
    Object localObject = null;
    if (paramInt1 == 1)
      localObject = new com.flagleader.builder.widget.editor.c.d(parama);
    else if (paramInt1 == 2)
      localObject = new com.flagleader.builder.widget.editor.f.b(parama);
    else if (paramInt1 == 3)
      localObject = new com.flagleader.builder.widget.editor.e.a(parama);
    else if (paramInt1 == 4)
      localObject = new com.flagleader.builder.widget.editor.i.c(parama);
    else if (paramInt1 == 5)
      localObject = new com.flagleader.builder.widget.editor.g.c(parama);
    else if (paramInt1 == 7)
      localObject = new com.flagleader.builder.widget.editor.j.c(parama);
    else if (paramInt1 == 8)
      localObject = new com.flagleader.builder.widget.editor.h.d(parama);
    else
      localObject = new s(parama);
    ((s)localObject).t = paramn;
    ((s)localObject).a(paramComposite, paramInt2);
    return (IPropertyChangeListener)localObject;
  }

  public Control a(Composite paramComposite, int paramInt)
  {
    this.j = a(b());
    this.m = new SourceViewer(paramComposite, null, paramInt);
    this.m.setDocument(this.j);
    this.p = new TextViewerUndoManager(100);
    this.p.connect(this.m);
    this.q = h();
    this.m.configure(this.q);
    H();
    I();
    if (this.t != null)
    {
      this.j.set(this.t.a());
      this.j.a(false);
      this.t.a(false);
    }
    this.p.reset();
    return paramComposite;
  }

  protected i a(n paramn)
  {
    return new i(paramn);
  }

  protected g h()
  {
    return new g(this);
  }

  public e i()
  {
    return new e(this);
  }

  public r j()
  {
    return new r(this);
  }

  public com.flagleader.builder.widget.editor.d.a k()
  {
    return new com.flagleader.builder.widget.editor.d.a();
  }

  private void H()
  {
    this.m.getTextWidget().setFont(BuilderConfig.getInstance().getTextFont());
  }

  private void I()
  {
    StyledText localStyledText = this.m.getTextWidget();
    localStyledText.setFont(BuilderConfig.getInstance().getTextFont());
    localStyledText.setBackground(h.d);
    localStyledText.setLayoutData(new GridData(1808));
    localStyledText.addVerifyKeyListener(new t(this, localStyledText));
    localStyledText.addMouseListener(new x(this));
    localStyledText.addKeyListener(new y(this, localStyledText));
  }

  public MenuManager l()
  {
    MenuManager localMenuManager1 = new MenuManager();
    MenuManager localMenuManager2 = new MenuManager("文件(&F)");
    MenuManager localMenuManager3 = new MenuManager("编辑(&E)");
    MenuManager localMenuManager4 = new MenuManager("帮助(&H)");
    localMenuManager2.add(new com.flagleader.builder.widget.editor.a.b(this));
    localMenuManager2.add(new com.flagleader.builder.widget.editor.a.e(this));
    localMenuManager2.add(new Separator());
    localMenuManager2.add(new com.flagleader.builder.widget.editor.a.c(this));
    localMenuManager3.add(new com.flagleader.builder.widget.editor.a.g(this));
    localMenuManager3.add(new com.flagleader.builder.widget.editor.a.d(this));
    localMenuManager3.add(new Separator());
    localMenuManager3.add(new f(this));
    localMenuManager3.add(new Separator());
    localMenuManager4.add(new com.flagleader.builder.widget.editor.a.a(this));
    localMenuManager1.add(localMenuManager2);
    localMenuManager1.add(localMenuManager3);
    localMenuManager1.add(localMenuManager4);
    return localMenuManager1;
  }

  public ToolBarManager b(int paramInt)
  {
    ToolBarManager localToolBarManager = new ToolBarManager(paramInt);
    localToolBarManager.add(new com.flagleader.builder.widget.editor.a.b(this));
    localToolBarManager.add(new com.flagleader.builder.widget.editor.a.e(this));
    localToolBarManager.add(new Separator());
    localToolBarManager.add(new com.flagleader.builder.widget.editor.a.c(this));
    localToolBarManager.add(new com.flagleader.builder.widget.editor.a.g(this));
    localToolBarManager.add(new com.flagleader.builder.widget.editor.a.d(this));
    localToolBarManager.add(new Separator());
    localToolBarManager.add(new f(this));
    localToolBarManager.add(new Separator());
    localToolBarManager.add(new com.flagleader.builder.widget.editor.a.a(this));
    return localToolBarManager;
  }

  public i m()
  {
    return this.j;
  }

  public SourceViewer n()
  {
    return this.m;
  }

  public j o()
  {
    return this.n;
  }

  public PreferenceStore p()
  {
    return this.o;
  }

  public void a(PreferenceStore paramPreferenceStore)
  {
    this.o = paramPreferenceStore;
  }

  public IUndoManager q()
  {
    return this.p;
  }

  public g r()
  {
    return this.q;
  }

  public void propertyChange(PropertyChangeEvent paramPropertyChangeEvent)
  {
    if (paramPropertyChangeEvent.getNewValue() == null)
      return;
    if (paramPropertyChangeEvent.getProperty().equals("Font"))
      this.n.a((FontData[])paramPropertyChangeEvent.getNewValue());
  }

  public o s()
  {
    return this.k;
  }

  public com.flagleader.manager.c.a t()
  {
    return this.l;
  }

  public String[] u()
  {
    return new String[] { "*.*" };
  }

  public boolean v()
  {
    return true;
  }

  public boolean g()
  {
    return q().redoable();
  }

  public boolean f()
  {
    return q().undoable();
  }

  public void w()
  {
    this.m.doOperation(4);
  }

  public void x()
  {
    this.m.doOperation(3);
  }

  public void y()
  {
    this.m.doOperation(6);
  }

  public void z()
  {
    new com.flagleader.builder.widget.editor.b.b(this, Display.getCurrent().getActiveShell()).open();
  }

  public void A()
  {
    String str = this.r;
    if ((this.m.getTextWidget().getSelectionText() != null) && (this.m.getTextWidget().getSelectionText().length() > 0))
      str = this.m.getTextWidget().getSelectionText();
    this.r = k.b(ResourceTools.getMessage("text_find_info"), str);
    if ((this.r != null) && (this.r.length() > 0))
    {
      int i = this.m.getTextWidget().getText().indexOf(this.r, this.m.getTextWidget().getCaretOffset());
      if (i >= 0)
        this.m.getTextWidget().setSelection(i, i + this.r.length());
    }
  }

  public void B()
  {
    StyledText localStyledText = this.m.getTextWidget();
    if ((this.r == null) || ((this.r.length() == 0) && ((localStyledText.getSelectionText() == null) || (localStyledText.getSelectionText().length() <= 0))))
    {
      A();
    }
    else
    {
      if ((localStyledText.getSelectionText() != null) && (localStyledText.getSelectionText().length() > 0))
        this.r = localStyledText.getSelectionText();
      if ((this.r != null) && (this.r.length() > 0))
      {
        int i = localStyledText.getText().indexOf(this.r, localStyledText.getCaretOffset());
        if (i >= 0)
          localStyledText.setSelection(i, i + this.r.length());
      }
    }
  }

  public void C()
  {
    StyledText localStyledText = this.m.getTextWidget();
    if ((localStyledText.getSelectionText() != null) && (localStyledText.getSelectionText().length() > 0))
      this.r = localStyledText.getSelectionText();
    if ((this.r != null) && (this.r.length() > 0))
    {
      String str = localStyledText.getText().substring(0, localStyledText.getCaretOffset() - 1);
      int i = str.lastIndexOf(this.r);
      if (i >= 0)
        localStyledText.setSelection(i, i + this.r.length());
    }
  }

  public void D()
  {
    this.m.doOperation(5);
  }

  public void d()
  {
    this.m.doOperation(10);
  }

  public boolean e()
  {
    q().redo();
    return true;
  }

  public void E()
  {
    this.m.doOperation(7);
  }

  public boolean c()
  {
    q().undo();
    return true;
  }

  public void a(Printer paramPrinter)
  {
    this.m.getTextWidget().print(paramPrinter);
  }

  protected Menu F()
  {
    Menu localMenu = h.a();
    MenuItem localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("undo.popup"));
    localMenuItem.setEnabled(f());
    localMenuItem.setAccelerator(SWT.MOD1 + 90);
    localMenuItem.addSelectionListener(new z(this));
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("redo.popup"));
    localMenuItem.setEnabled(g());
    localMenuItem.setAccelerator(SWT.MOD1 + 89);
    localMenuItem.addSelectionListener(new A(this));
    new MenuItem(localMenu, 2);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("cut.popup"));
    localMenuItem.setAccelerator(SWT.MOD1 + 88);
    localMenuItem.addSelectionListener(new B(this));
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("copy.popup"));
    localMenuItem.addSelectionListener(new C(this));
    localMenuItem.setAccelerator(SWT.MOD1 + 67);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("paste.popup"));
    localMenuItem.addSelectionListener(new D(this));
    localMenuItem.setAccelerator(SWT.MOD1 + 86);
    new MenuItem(localMenu, 2);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("selectall.popup"));
    localMenuItem.addSelectionListener(new E(this));
    localMenuItem.setAccelerator(SWT.MOD1 + 65);
    new MenuItem(localMenu, 2);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("delete.popup"));
    localMenuItem.addSelectionListener(new u(this));
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("search.popup"));
    localMenuItem.addSelectionListener(new v(this));
    new MenuItem(localMenu, 2);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("setfont.popup"));
    localMenuItem.addSelectionListener(new w(this));
    return localMenu;
  }

  public void G()
  {
    FontDialog localFontDialog = new FontDialog(this.m.getTextWidget().getShell());
    localFontDialog.setFontList(BuilderConfig.getInstance().getTextFont().getFontData());
    FontData localFontData = localFontDialog.open();
    if (localFontData == null)
      return;
    BuilderConfig.getInstance().setTextFont(new Font(Display.getCurrent(), localFontData));
    this.m.getTextWidget().setFont(BuilderConfig.getInstance().getTextFont());
  }

  public StyledText a()
  {
    return this.m.getTextWidget();
  }

  public void a(String paramString)
  {
    m().set(paramString);
    m().a(false);
  }

  public boolean a(int paramInt)
  {
    return m().b(paramInt);
  }

  public n b()
  {
    if (this.t == null)
      this.t = new c();
    return this.t;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.editor.s
 * JD-Core Version:    0.6.0
 */
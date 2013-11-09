package com.flagleader.builder.widget.a;

import com.flagleader.builder.BuilderConfig;
import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.k;
import com.flagleader.builder.widget.B;
import com.flagleader.builder.widget.h;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class af extends B
  implements q
{
  protected StyledText e;
  private BuilderManager f;
  private HashMap g = new HashMap();
  private HashMap h = new HashMap();
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private String m = "";
  private Menu n = null;

  public af(BuilderManager paramBuilderManager, Composite paramComposite, int paramInt)
  {
    this.f = paramBuilderManager;
    addObserver(this.f.getMenuAndToolBar());
    this.e = a(paramComposite, paramInt);
  }

  public af(Composite paramComposite, int paramInt)
  {
    this.e = a(paramComposite, paramInt);
  }

  protected StyledText a(Composite paramComposite, int paramInt)
  {
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginHeight = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    paramComposite.setLayout(localGridLayout);
    paramComposite.setLayoutData(new GridData(1808));
    this.e = new StyledText(paramComposite, paramInt);
    this.e.setFont(BuilderConfig.getInstance().getTextFont());
    this.e.setBackground(h.d);
    this.e.setLayoutData(new GridData(1808));
    this.e.addVerifyKeyListener(new ag(this));
    this.e.addMouseListener(new ah(this));
    this.e.addKeyListener(new ai(this));
    this.e.addFocusListener(new aj(this));
    this.e.addModifyListener(new ak(this));
    return this.e;
  }

  public void b(Composite paramComposite, int paramInt)
  {
    String str = this.e.getText();
    this.e.dispose();
    a(paramComposite, paramInt);
    this.e.setText(str);
  }

  protected Menu i()
  {
    Menu localMenu = n();
    MenuItem localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("undo.popup"));
    localMenuItem.setEnabled(o());
    localMenuItem.setAccelerator(SWT.MOD1 + 90);
    localMenuItem.addSelectionListener(new al(this));
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("redo.popup"));
    localMenuItem.setEnabled(o());
    localMenuItem.setAccelerator(SWT.MOD1 + 89);
    localMenuItem.addSelectionListener(new am(this));
    new MenuItem(localMenu, 2);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("cut.popup"));
    localMenuItem.setEnabled(o());
    localMenuItem.setAccelerator(SWT.MOD1 + 88);
    localMenuItem.addSelectionListener(new aq(this));
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("copy.popup"));
    localMenuItem.setEnabled(j());
    localMenuItem.addSelectionListener(new ap(this));
    localMenuItem.setAccelerator(SWT.MOD1 + 67);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("paste.popup"));
    localMenuItem.setEnabled(p());
    localMenuItem.addSelectionListener(new as(this));
    localMenuItem.setAccelerator(SWT.MOD1 + 86);
    new MenuItem(localMenu, 2);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("selectall.popup"));
    localMenuItem.addSelectionListener(new at(this));
    localMenuItem.setAccelerator(SWT.MOD1 + 65);
    new MenuItem(localMenu, 2);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("delete.popup"));
    localMenuItem.setEnabled(q());
    localMenuItem.addSelectionListener(new ar(this));
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("search.popup"));
    localMenuItem.addSelectionListener(new an(this));
    new MenuItem(localMenu, 2);
    localMenuItem = new MenuItem(localMenu, 8);
    localMenuItem.setText(ResourceTools.getMessage("setfont.popup"));
    localMenuItem.addSelectionListener(new ao(this));
    return localMenu;
  }

  public void k()
  {
    FontDialog localFontDialog = new FontDialog(this.e.getShell());
    localFontDialog.setFontList(BuilderConfig.getInstance().getTextFont().getFontData());
    FontData localFontData = localFontDialog.open();
    if (localFontData == null)
      return;
    BuilderConfig.getInstance().setTextFont(new Font(this.e.getDisplay(), localFontData));
    this.e.setFont(BuilderConfig.getInstance().getTextFont());
  }

  public void A()
  {
    String str = this.m;
    if ((this.e.getSelectionText() != null) && (this.e.getSelectionText().length() > 0))
      str = this.e.getSelectionText();
    this.m = k.b(ResourceTools.getMessage("text_find_info"), str);
    if ((this.m != null) && (this.m.length() > 0))
    {
      int i1 = this.e.getText().indexOf(this.m, this.e.getCaretOffset());
      if (i1 >= 0)
        this.e.setSelection(i1, i1 + this.m.length());
    }
  }

  public void B()
  {
    if ((this.m == null) || ((this.m.length() == 0) && ((this.e.getSelectionText() == null) || (this.e.getSelectionText().length() <= 0))))
    {
      A();
    }
    else
    {
      if ((this.e.getSelectionText() != null) && (this.e.getSelectionText().length() > 0))
        this.m = this.e.getSelectionText();
      if ((this.m != null) && (this.m.length() > 0))
      {
        int i1 = this.e.getText().indexOf(this.m, this.e.getCaretOffset());
        if (i1 >= 0)
          this.e.setSelection(i1, i1 + this.m.length());
      }
    }
  }

  public void l()
  {
    if ((this.e.getSelectionText() != null) && (this.e.getSelectionText().length() > 0))
      this.m = this.e.getSelectionText();
    if ((this.m != null) && (this.m.length() > 0))
    {
      String str = this.e.getText().substring(0, this.e.getCaretOffset());
      int i1 = str.lastIndexOf(this.m);
      if (i1 >= 0)
        this.e.setSelection(i1, i1 + this.m.length());
    }
  }

  private boolean j()
  {
    return this.i;
  }

  private boolean o()
  {
    return this.j;
  }

  private boolean p()
  {
    return this.k;
  }

  private boolean q()
  {
    return this.l;
  }

  private void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  private void c(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  private void d(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  private void e(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public boolean v()
  {
    return this.e != null;
  }

  public void w()
  {
    if (this.e != null)
      this.e.copy();
  }

  public void x()
  {
    if (this.e != null)
      this.e.cut();
  }

  public void D()
  {
    if (this.e != null)
      this.e.paste();
  }

  public void y()
  {
    s();
  }

  public void d()
  {
    if (this.e != null)
      this.e.print();
  }

  public void a(Printer paramPrinter)
  {
    if (this.e != null)
      this.e.print(paramPrinter);
  }

  public void E()
  {
    if (this.e != null)
      this.e.selectAll();
  }

  private void r()
  {
    Point localPoint = this.e.getSelectionRange();
    int i1 = localPoint.x;
    String str1 = this.e.getText();
    String str2 = str1.substring(0, localPoint.x) + str1.substring(localPoint.x + localPoint.y, str1.length());
    this.e.setText(str2);
    this.e.setCaretOffset(i1);
  }

  private void s()
  {
    if (this.e.getSelectionCount() > 0)
      r();
  }

  public void restoreState(Hashtable paramHashtable)
  {
    Object localObject1 = paramHashtable.get("Text");
    Object localObject2 = paramHashtable.get("Pos");
    if ((localObject1 != null) && (localObject2 != null) && ((localObject2 instanceof Integer)) && (!this.e.isDisposed()))
    {
      int i1 = ((Integer)localObject2).intValue();
      this.e.setText(localObject1.toString());
      this.e.setSelection(i1);
    }
  }

  public void storeState(Hashtable paramHashtable)
  {
    paramHashtable.put("Pos", new Integer(this.e.getCaretOffset()));
    paramHashtable.put("Text", this.e.getText());
  }

  public void a(List paramList)
  {
  }

  public void a(String paramString)
  {
    if ((this.e != null) && (!this.e.isDisposed()))
      this.e.setText(paramString);
  }

  public StyledText m()
  {
    return this.e;
  }

  protected Menu n()
  {
    return h.a();
  }

  public void z()
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.widget.a.af
 * JD-Core Version:    0.6.0
 */
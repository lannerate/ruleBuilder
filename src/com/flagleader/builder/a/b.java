package com.flagleader.builder.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.actions.aq;
import com.flagleader.builder.widget.a;
import com.flagleader.repository.IElement;
import com.flagleader.repository.IElementViewer;
import com.flagleader.repository.d.u;
import com.flagleader.repository.e.r;
import com.flagleader.repository.k;
import com.flagleader.repository.rlm.editen.IEditen;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.IModifierEditen;
import com.flagleader.repository.rlm.editen.IMultiLineEditen;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.editen.ISheetAndFieldEditen;
import com.flagleader.repository.rlm.editen.ISheetAndWhereEditen;
import com.flagleader.repository.rlm.editen.ISheetDynamicEditen;
import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
import com.flagleader.repository.rlm.editen.ISheetFieldEditen;
import com.flagleader.repository.rlm.editen.ISheetFieldsSelectEditen;
import com.flagleader.repository.rlm.editen.ISheetFunctionEditen;
import com.flagleader.repository.rlm.editen.ISheetWhereEditen;
import com.flagleader.repository.rlm.editen.IStaticEditen;
import com.flagleader.repository.rlm.editen.ITextEditen;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.rom.ISubFunction;
import com.flagleader.repository.rom.ISubVariable;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.tree.ITreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

public abstract class b extends r
  implements IElementViewer
{
  protected bu a;
  protected BuilderManager b;
  protected Composite c;
  private Composite l;
  protected Composite d;
  private com.flagleader.builder.widget.w m;
  private static final Color n = Display.getCurrent().getSystemColor(29);
  private static final Color o = Display.getCurrent().getSystemColor(25);
  private static final Color p = Display.getCurrent().getSystemColor(27);
  private static final Font q = new Font(null, "Tahoma", 8, 0);
  private static final Color r = Display.getCurrent().getSystemColor(15);
  private static HashMap s = new HashMap();
  private Menu t = null;
  private static final String u = "&update";
  protected long e = 0L;
  protected Control f;
  protected Control g;
  protected Composite h;
  protected ToolBar i;
  protected HashMap j = new HashMap();

  public b(Composite paramComposite, bu parambu)
  {
    this.a = parambu;
    if (parambu != null)
      this.b = parambu.i();
    this.c = paramComposite;
    a();
    a(this.c);
    if (this.b != null)
      addObserver(this.b.getMenuAndToolBar());
  }

  protected void a(com.flagleader.builder.a.c.b paramb)
  {
    this.j.put(paramb.c(), paramb);
  }

  protected void a(KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.keyCode == 127) && (canDelete()))
    {
      delete();
      paramKeyEvent.doit = false;
    }
    if (paramKeyEvent.keyCode == 16777230)
    {
      update();
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

  protected void a()
  {
    a(new ak(this));
    a(new al(this));
    a(new aj(this));
    a(new ai(this));
    a(new am(this));
    a(new ag(this));
    a(new af(this));
    a(new ah(this));
  }

  protected Control a(Composite paramComposite)
  {
    this.g = c(paramComposite);
    this.f = b(paramComposite);
    return paramComposite;
  }

  protected Control b(Composite paramComposite)
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
    d(localComposite);
    return localComposite;
  }

  protected synchronized void setChanged()
  {
    b();
    super.setChanged();
  }

  protected Control c(Composite paramComposite)
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
    this.i = new ToolBar(localComposite2, 256);
    a(this.i);
    this.h = new Composite(localComposite1, 0);
    localGridLayout = new GridLayout();
    localGridLayout.horizontalSpacing = 0;
    localGridLayout.verticalSpacing = 0;
    localGridLayout.marginWidth = 0;
    localGridLayout.marginHeight = 0;
    localGridLayout.numColumns = 10;
    this.h.setLayout(localGridLayout);
    localGridData = new GridData(131072, 16777216, true, false);
    localGridData.widthHint = 150;
    localGridData.heightHint = 20;
    this.h.setLayoutData(localGridData);
    this.h.setFont(paramComposite.getFont());
    return localComposite1;
  }

  protected void b()
  {
    ToolItem[] arrayOfToolItem = this.i.getItems();
    for (int k = 0; k < arrayOfToolItem.length; k++)
    {
      com.flagleader.builder.a.c.b localb = (com.flagleader.builder.a.c.b)arrayOfToolItem[k].getData();
      if (localb == null)
        continue;
      if (localb.b())
        arrayOfToolItem[k].setEnabled(true);
      else
        arrayOfToolItem[k].setEnabled(false);
      if (localb.g() == 1)
      {
        if (!localb.h())
          continue;
        arrayOfToolItem[k].setSelection(true);
      }
      else
      {
        if (localb.g() != 2)
          continue;
        ((Combo)arrayOfToolItem[k].getControl()).setItems(localb.i());
        ((Combo)arrayOfToolItem[k].getControl()).setText(localb.j());
        ((Combo)arrayOfToolItem[k].getControl()).pack();
        arrayOfToolItem[k].setWidth(((Combo)arrayOfToolItem[k].getControl()).getSize().x);
      }
    }
  }

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
    a(paramToolBar, "update");
    b();
  }

  protected ToolItem a(ToolBar paramToolBar, String paramString)
  {
    com.flagleader.builder.a.c.b localb = a(paramString);
    if (localb != null)
    {
      ToolItem localToolItem;
      if (localb.g() == 2)
      {
        localToolItem = new ToolItem(paramToolBar, 2);
        localToolItem.setToolTipText("SWT.SEPARATOR");
        Combo localCombo = new Combo(paramToolBar, 8);
        localCombo.pack();
        localToolItem.setWidth(localCombo.getSize().x);
        localToolItem.setControl(localCombo);
        localCombo.addSelectionListener(new c(this, localb, localCombo));
        localToolItem.setData(localb);
      }
      else
      {
        if (localb.g() == 1)
        {
          localToolItem = new ToolItem(paramToolBar, 32);
          localToolItem.setImage(ResourceTools.getImage(localb.d()));
          localToolItem.setToolTipText(localb.f());
          localToolItem.addSelectionListener(new C(this, localb, localToolItem));
          localToolItem.setData(localb);
          return localToolItem;
        }
        localToolItem = new ToolItem(paramToolBar, 8);
        localToolItem.setImage(ResourceTools.getImage(localb.d()));
        localToolItem.setToolTipText(localb.f());
        localToolItem.addSelectionListener(new V(this, localb));
        localToolItem.setData(localb);
        return localToolItem;
      }
    }
    return null;
  }

  protected com.flagleader.builder.a.c.b a(String paramString)
  {
    return (com.flagleader.builder.a.c.b)this.j.get(paramString);
  }

  protected MenuItem a(Menu paramMenu, String paramString)
  {
    com.flagleader.builder.a.c.b localb = a(paramString);
    if ((localb != null) && (localb.b()))
    {
      MenuItem localMenuItem = new MenuItem(paramMenu, 8);
      localMenuItem.setText(localb.e());
      localMenuItem.addListener(13, new W(this, localb));
      return localMenuItem;
    }
    return null;
  }

  protected void b(String paramString)
  {
    Composite localComposite = c();
    Label localLabel = new Label(localComposite, 0);
    localLabel.setBackground(o);
    localLabel.setText(paramString);
    localLabel.setFont(new Font(null, "Tahoma", 12, 1));
    localComposite.setSize(localComposite.computeSize(-1, -1));
  }

  protected void a(ISelectorEditen paramISelectorEditen)
  {
    if (paramISelectorEditen.hasHint())
      a(this.d, paramISelectorEditen.getHint(), paramISelectorEditen.getColorType());
    Object localObject;
    if (paramISelectorEditen.canEdit())
    {
      localObject = c("inputValue.edit");
      if (paramISelectorEditen.getDisplayName().length() > 0)
        localObject = paramISelectorEditen.getDisplayName();
      Label localLabel = a(this.d, (String)localObject, paramISelectorEditen.getColorType());
      ISelectorEditen localISelectorEditen = paramISelectorEditen;
      localLabel.addMouseListener(new X(this, localLabel, localISelectorEditen));
      a(localLabel, paramISelectorEditen.getNote());
    }
    else if (paramISelectorEditen.hasLeftPopupMenus())
    {
      localObject = a(this.d, paramISelectorEditen.getDisplayName(), paramISelectorEditen.getColorType());
      a((Label)localObject, paramISelectorEditen);
      a((Label)localObject, paramISelectorEditen.getNote());
    }
  }

  protected void a(ISheetFieldEditen paramISheetFieldEditen)
  {
    if (paramISheetFieldEditen.hasHint())
      a(this.d, paramISheetFieldEditen.getHint(), paramISheetFieldEditen.getColorType());
    if (paramISheetFieldEditen.hasSelects())
    {
      Label localLabel = a(this.d, paramISheetFieldEditen.getDisplayName(), paramISheetFieldEditen.getColorType());
      if (!paramISheetFieldEditen.isLocked())
      {
        localObject = paramISheetFieldEditen;
        localLabel.addMouseListener(new Y(this, localLabel, (ISheetFieldEditen)localObject));
      }
      Object localObject = paramISheetFieldEditen.getNote();
      localLabel.setToolTipText((String)localObject);
    }
  }

  protected void a(ISheetFieldsSelectEditen paramISheetFieldsSelectEditen)
  {
    if (paramISheetFieldsSelectEditen.hasHint())
      a(this.d, paramISheetFieldsSelectEditen.getHint(), paramISheetFieldsSelectEditen.getColorType());
    if (paramISheetFieldsSelectEditen.hasSelects())
    {
      Label localLabel = a(this.d, paramISheetFieldsSelectEditen.getDisplayName(), paramISheetFieldsSelectEditen.getColorType());
      if (!paramISheetFieldsSelectEditen.isLocked())
      {
        localObject = paramISheetFieldsSelectEditen;
        localLabel.addMouseListener(new Z(this, localLabel, (ISheetFieldsSelectEditen)localObject, paramISheetFieldsSelectEditen));
      }
      Object localObject = paramISheetFieldsSelectEditen.getNote();
      localLabel.setToolTipText((String)localObject);
    }
  }

  protected void a(ISheetAndFieldEditen paramISheetAndFieldEditen)
  {
    if (paramISheetAndFieldEditen.hasHint())
      a(this.d, paramISheetAndFieldEditen.getHint(), paramISheetAndFieldEditen.getColorType());
    Label localLabel = a(this.d, paramISheetAndFieldEditen.getDisplayName(), paramISheetAndFieldEditen.getColorType());
    if (!paramISheetAndFieldEditen.isLocked())
    {
      localObject = paramISheetAndFieldEditen;
      localLabel.addMouseListener(new ab(this, localLabel, (ISheetAndFieldEditen)localObject, paramISheetAndFieldEditen));
    }
    Object localObject = paramISheetAndFieldEditen.getNote();
    localLabel.setToolTipText((String)localObject);
  }

  protected void a(ISheetFentanEditen paramISheetFentanEditen)
  {
    if (paramISheetFentanEditen.hasHint())
      a(this.d, paramISheetFentanEditen.getHint(), paramISheetFentanEditen.getColorType());
    Label localLabel = a(this.d, paramISheetFentanEditen.getDisplayName(), paramISheetFentanEditen.getColorType());
    if (!paramISheetFentanEditen.isLocked())
    {
      localObject = paramISheetFentanEditen;
      localLabel.addMouseListener(new ad(this, localLabel, (ISheetFentanEditen)localObject, paramISheetFentanEditen));
    }
    Object localObject = paramISheetFentanEditen.getNote();
    localLabel.setToolTipText((String)localObject);
  }

  protected void a(ISheetDynamicEditen paramISheetDynamicEditen)
  {
    if (paramISheetDynamicEditen.hasHint())
      a(this.d, paramISheetDynamicEditen.getHint(), paramISheetDynamicEditen.getColorType());
    Label localLabel = a(this.d, paramISheetDynamicEditen.getDisplayName(), paramISheetDynamicEditen.getColorType());
    if (!paramISheetDynamicEditen.isLocked())
    {
      localObject = paramISheetDynamicEditen;
      localLabel.addMouseListener(new d(this, localLabel, (ISheetDynamicEditen)localObject, paramISheetDynamicEditen));
    }
    Object localObject = paramISheetDynamicEditen.getNote();
    localLabel.setToolTipText((String)localObject);
  }

  protected void a(ISheetAndWhereEditen paramISheetAndWhereEditen)
  {
    if (paramISheetAndWhereEditen.hasHint())
      a(this.d, paramISheetAndWhereEditen.getHint(), paramISheetAndWhereEditen.getColorType());
    Label localLabel = a(this.d, paramISheetAndWhereEditen.getDisplayName(), paramISheetAndWhereEditen.getColorType());
    if (!paramISheetAndWhereEditen.isLocked())
    {
      localObject = paramISheetAndWhereEditen;
      localLabel.addMouseListener(new f(this, localLabel, (ISheetAndWhereEditen)localObject, paramISheetAndWhereEditen));
    }
    Object localObject = paramISheetAndWhereEditen.getNote();
    localLabel.setToolTipText((String)localObject);
  }

  protected void a(ISelectRulePackageEditen paramISelectRulePackageEditen)
  {
    if (paramISelectRulePackageEditen.hasHint())
      a(this.d, paramISelectRulePackageEditen.getHint(), paramISelectRulePackageEditen.getColorType());
    Label localLabel = a(this.d, paramISelectRulePackageEditen.getDisplayName(), paramISelectRulePackageEditen.getColorType());
    if (!paramISelectRulePackageEditen.isLocked())
    {
      localObject = paramISelectRulePackageEditen;
      localLabel.addMouseListener(new h(this, localLabel, (ISelectRulePackageEditen)localObject, paramISelectRulePackageEditen));
    }
    Object localObject = paramISelectRulePackageEditen.getNote();
    localLabel.setToolTipText((String)localObject);
  }

  protected void a(ISheetFunctionEditen paramISheetFunctionEditen)
  {
    if (paramISheetFunctionEditen.hasHint())
      a(this.d, paramISheetFunctionEditen.getHint(), paramISheetFunctionEditen.getColorType());
    Label localLabel = a(this.d, paramISheetFunctionEditen.getDisplayName(), paramISheetFunctionEditen.getColorType());
    if (!paramISheetFunctionEditen.isLocked())
    {
      localObject = paramISheetFunctionEditen;
      localLabel.addMouseListener(new j(this, localLabel, (ISheetFunctionEditen)localObject, paramISheetFunctionEditen));
    }
    Object localObject = paramISheetFunctionEditen.getNote();
    localLabel.setToolTipText((String)localObject);
  }

  protected void a(ISheetWhereEditen paramISheetWhereEditen)
  {
    if (paramISheetWhereEditen.hasHint())
      a(this.d, paramISheetWhereEditen.getHint(), paramISheetWhereEditen.getColorType());
    Label localLabel = a(this.d, paramISheetWhereEditen.getDisplayName(), paramISheetWhereEditen.getColorType());
    if (!paramISheetWhereEditen.isLocked())
    {
      localObject = paramISheetWhereEditen;
      localLabel.addMouseListener(new l(this, localLabel, (ISheetWhereEditen)localObject, paramISheetWhereEditen));
    }
    Object localObject = paramISheetWhereEditen.getNote();
    localLabel.setToolTipText((String)localObject);
  }

  protected void a(IStaticEditen paramIStaticEditen)
  {
    Label localLabel = a(this.d, paramIStaticEditen.getDisplayName(), paramIStaticEditen.getColorType());
    localLabel.addMouseListener(new n(this));
  }

  protected void a(ITextEditen paramITextEditen)
  {
    if (paramITextEditen.hasHint())
      a(this.d, paramITextEditen.getHint(), paramITextEditen.getColorType());
    String str = c("inputValue.edit");
    if (paramITextEditen.getDisplayName().length() > 0)
      str = paramITextEditen.getDisplayName();
    Label localLabel = a(this.d, str, paramITextEditen.getColorType());
    ITextEditen localITextEditen = paramITextEditen;
    localLabel.addMouseListener(new o(this, localLabel, localITextEditen, paramITextEditen));
    a(localLabel, paramITextEditen.getNote());
  }

  protected void a(IModifierEditen paramIModifierEditen)
  {
    Label localLabel = new Label(this.d, 8);
    GridData localGridData = new GridData();
    localGridData.heightHint = 11;
    localLabel.setLayoutData(localGridData);
    localLabel.setImage(ResourceTools.getImage(paramIModifierEditen.getImageName() + ".icon"));
    localLabel.setBackground(n);
    a(localLabel, paramIModifierEditen.getNote());
    localLabel.setCursor(Display.getCurrent().getSystemCursor(21));
    k localk = paramIModifierEditen.getEvent();
    IModifierEditen localIModifierEditen = paramIModifierEditen;
    localLabel.addMouseListener(new w(this, localk, localLabel, localIModifierEditen));
  }

  protected void a(IEditen paramIEditen)
  {
    if ((paramIEditen instanceof IMultiLineEditen))
    {
      paramIEditen.setElementEditor(new A(this));
    }
    else if ((paramIEditen instanceof ILineEditen))
    {
      Composite localComposite = this.d;
      paramIEditen.setElementEditor(new B(this, localComposite, paramIEditen));
      this.d.setData(paramIEditen);
      this.d.setSize(this.d.computeSize(-1, -1));
    }
  }

  protected void b(IEditen paramIEditen)
  {
    this.d = c();
    this.d.setData(paramIEditen);
  }

  private void d(Composite paramComposite)
  {
    this.m = new com.flagleader.builder.widget.w(paramComposite, 768);
    this.m.setLayoutData(new GridData(1808));
    this.m.setBackground(o);
    this.m.b(true);
    this.m.c(true);
  }

  private Button e(Composite paramComposite)
  {
    Button localButton = new Button(paramComposite, 8);
    return localButton;
  }

  protected String c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return "";
    if (paramString.charAt(0) == '&')
      return ResourceTools.getMessage(paramString.substring(1) + ".edit", paramString.substring(1));
    return ResourceTools.getMessage(paramString, paramString);
  }

  private Label a(Composite paramComposite, String paramString1, String paramString2)
  {
    a locala = new a(paramComposite, d(paramString1), 20, 0);
    locala.a(p);
    if (paramString1.equals("&"))
      locala.a("＆");
    else
      locala.a(paramString1);
    locala.b(n);
    if (paramString1.equals("[]"))
      locala.setForeground(e("select"));
    else
      locala.setForeground(e(paramString2));
    locala.setFont(q);
    locala.setBackground(o);
    return locala.b();
  }

  private int d(String paramString)
  {
    return 7 * paramString.getBytes().length + 8;
  }

  protected Composite c()
  {
    Composite localComposite = new Composite(this.l, 0);
    localComposite.setLayout(com.flagleader.builder.widget.h.a(100, new int[4]));
    localComposite.setLayoutData(new GridData(32));
    localComposite.setBackground(o);
    return localComposite;
  }

  public void update()
  {
    try
    {
      if ((this.c == null) || (this.c.isDisposed()))
        return;
      Point localPoint = this.m.f();
      d();
      h();
      e();
      if ((this.b != null) && (this.b.getMessageWindow().b().getItems() != null))
        this.b.getMessageWindow().b().removeAll();
      if (this.l.getSize() != this.l.computeSize(-1, -1))
      {
        this.l.setSize(this.l.computeSize(-1, -1));
        this.m.b(this.l.computeSize(-1, -1));
        this.m.redraw();
      }
      this.m.c(localPoint);
      this.e = System.currentTimeMillis();
    }
    catch (SWTError localSWTError)
    {
      localSWTError.printStackTrace();
      this.a.g();
    }
  }

  private void a(Composite paramComposite, ILineEditen paramILineEditen)
  {
    this.d = paramComposite;
    while (paramComposite.getChildren().length > 0)
      paramComposite.getChildren()[0].dispose();
    if (this.d.getSize() != this.d.computeSize(-1, -1))
      this.d.setSize(this.d.computeSize(-1, -1));
    paramILineEditen.acceptVisitor(this);
    if (this.l.getSize() != this.l.computeSize(-1, -1))
    {
      this.l.setSize(this.l.computeSize(-1, -1));
      this.m.b(this.l.computeSize(-1, -1));
    }
  }

  protected void d()
  {
    if (this.l != null)
    {
      this.l.dispose();
      this.l = null;
    }
    this.d = null;
  }

  protected abstract void e();

  private void h()
  {
    this.l = new Composite(this.m, 0);
    this.l.setBackground(o);
    this.m.a(this.l);
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    localGridLayout.marginLeft = 1;
    localGridLayout.marginTop = 1;
    localGridLayout.horizontalSpacing = 1;
    localGridLayout.verticalSpacing = 1;
    this.l.setLayout(localGridLayout);
    this.l.setLayoutData(new GridData(1808));
    this.l.setSize(this.l.computeSize(-1, -1));
    this.m.b(this.m.computeSize(-1, -1));
    this.l.addMouseListener(new D(this));
    this.l.addMouseMoveListener(new E(this));
  }

  private void f(Composite paramComposite)
  {
    paramComposite.setBackground(r);
    Control[] arrayOfControl = paramComposite.getChildren();
    for (int k = 0; k < arrayOfControl.length; k++)
      arrayOfControl[k].setBackground(r);
  }

  private void g(Composite paramComposite)
  {
    paramComposite.setBackground(o);
    Control[] arrayOfControl = paramComposite.getChildren();
    for (int k = 0; k < arrayOfControl.length; k++)
      arrayOfControl[k].setBackground(o);
  }

  public void selectAll()
  {
    Control[] arrayOfControl = this.l.getChildren();
    for (int k = 0; k < arrayOfControl.length; k++)
    {
      if ((!(arrayOfControl[k] instanceof Composite)) || (arrayOfControl[k].getData() == null))
        continue;
      f((Composite)arrayOfControl[k]);
    }
    setChanged();
    notifyObservers();
  }

  public void find()
  {
  }

  public void findNext()
  {
  }

  public boolean isCanFind()
  {
    return false;
  }

  public boolean isCanSelectAll()
  {
    return true;
  }

  protected List f()
  {
    if ((this.l != null) && (!this.l.isDisposed()))
    {
      Control[] arrayOfControl = this.l.getChildren();
      ArrayList localArrayList = new ArrayList(arrayOfControl.length);
      for (int k = 0; k < arrayOfControl.length; k++)
      {
        if ((!arrayOfControl[k].getBackground().equals(r)) || (arrayOfControl[k].getData() == null) || (!(arrayOfControl[k].getData() instanceof ILineEditen)))
          continue;
        localArrayList.add(arrayOfControl[k].getData());
      }
      return localArrayList;
    }
    return new ArrayList(0);
  }

  private void a(MouseEvent paramMouseEvent)
  {
    if (paramMouseEvent.button == 3)
    {
      Menu localMenu = com.flagleader.builder.widget.h.a();
      if (f().size() > 0)
      {
        if (!g())
        {
          localMenuItem = new MenuItem(localMenu, 64);
          localMenuItem.setText(c("cut.popup"));
          localMenuItem.addListener(13, new F(this));
        }
        localMenuItem = new MenuItem(localMenu, 64);
        localMenuItem.setText(c("copy.popup"));
        localMenuItem.addListener(13, new G(this));
      }
      MenuItem localMenuItem = new MenuItem(localMenu, 8);
      localMenuItem.setText(c("&update"));
      localMenuItem.addListener(13, new H(this));
      localMenu.setEnabled(true);
      localMenu.setVisible(true);
    }
  }

  public abstract void cut();

  public abstract void copy();

  public void a(IElement paramIElement)
  {
    new Clipboard(Display.getCurrent()).setContents(new Object[] { paramIElement }, new Transfer[] { com.flagleader.builder.widget.d.a() });
  }

  private void a(Label paramLabel, ISelectorEditen paramISelectorEditen)
  {
    paramLabel.addMouseListener(new I(this, paramISelectorEditen));
    DropTarget localDropTarget = new DropTarget(paramLabel, 19);
    localDropTarget.setTransfer(new Transfer[] { TextTransfer.getInstance(), com.flagleader.builder.widget.d.a() });
    localDropTarget.addDropListener(new T(this, paramISelectorEditen));
  }

  private Image a(ITreeNode paramITreeNode)
  {
    return ResourceTools.getIcon(paramITreeNode);
  }

  private void a(Menu paramMenu, com.flagleader.repository.l[] paramArrayOfl)
  {
    if ((paramArrayOfl == null) || (paramArrayOfl.length == 0))
      return;
    for (int k = 0; k < paramArrayOfl.length; k++)
    {
      String str = paramArrayOfl[k].b();
      if ((this.a.i().getConfigManager().F()) && (paramArrayOfl[k].e() != null) && ((paramArrayOfl[k].e() instanceof IVariableObject)))
        str = str + "\t\t\t(" + ((IVariableObject)paramArrayOfl[k].e()).getValueName() + ")";
      k localk = paramArrayOfl[k].a();
      MenuItem localMenuItem = new MenuItem(paramMenu, 64);
      if ((paramArrayOfl[k].e() instanceof ITreeNode))
        localMenuItem.setImage(a((ITreeNode)paramArrayOfl[k].e()));
      else if ((paramArrayOfl[k].e() instanceof ISubFunction))
        localMenuItem.setImage(ResourceTools.getImage("classsubfunction.icon"));
      else if ((paramArrayOfl[k].e() instanceof ISubVariable))
        localMenuItem.setImage(ResourceTools.getImage("classsubvariable.icon"));
      else if ((paramArrayOfl[k].e() instanceof IFunctionObject))
        localMenuItem.setImage(ResourceTools.getImage("classfunction.icon"));
      else if ((paramArrayOfl[k].e() instanceof IVariableObject))
        localMenuItem.setImage(ResourceTools.getImage("classvariable.icon"));
      if (paramArrayOfl[k].d().length > 0)
      {
        localMenuItem.setMenu(new Menu(localMenuItem));
        a(localMenuItem.getMenu(), paramArrayOfl[k].d());
      }
      localMenuItem.setText(c(str));
      localMenuItem.addListener(13, new U(this, localk));
    }
    paramMenu.setEnabled(true);
    paramMenu.setVisible(true);
  }

  private static Color e(String paramString)
  {
    if (s.get(paramString) != null)
      return (Color)s.get(paramString);
    String[] arrayOfString = u.b(paramString + ".color");
    if ((arrayOfString != null) && (arrayOfString.length == 3))
    {
      Color localColor = new Color(null, Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1]), Integer.parseInt(arrayOfString[2]));
      s.put(paramString, localColor);
      return localColor;
    }
    return p;
  }

  private void a(Label paramLabel, String paramString)
  {
    int k = paramString.length();
    if ((paramString != null) && (k > 150))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i1 = 0; i1 < k; i1 += 100)
        if (k - i1 < 100)
          localStringBuffer.append(paramString.substring(i1, k));
        else
          localStringBuffer.append(paramString.substring(i1, i1 + 100)).append("\n");
      paramLabel.setToolTipText(localStringBuffer.toString());
    }
    else
    {
      paramLabel.setToolTipText(paramString);
    }
  }

  public void dispose()
  {
    if ((this.t != null) && (!this.t.isDisposed()))
      this.t.dispose();
  }

  protected abstract boolean g();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.b
 * JD-Core Version:    0.6.0
 */
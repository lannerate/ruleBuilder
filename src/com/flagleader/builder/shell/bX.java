package com.flagleader.builder.shell;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.a.X;
import com.flagleader.builder.widget.h;
import com.flagleader.builder.widget.s;
import com.flagleader.repository.export.RspTags;
import com.flagleader.repository.export.Tag;
import com.flagleader.repository.export.TagType;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class bX
{
  Shell a;
  String b;
  ToolBar c;
  private Menu d;
  private Composite e;
  private Composite f;
  private Tree g;
  private int h = 0;
  private SashForm i;
  private int[] j;
  private CTabItem k;
  private CTabItem l;
  private CTabFolder m;
  private cA n;
  private cA o;
  private boolean p = false;
  private RspTags q;
  private HashMap r = new HashMap();
  private HashMap s = new HashMap();

  public bX(RspTags paramRspTags)
  {
    this.q = paramRspTags;
  }

  Menu a()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("SaveItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 83);
    localMenuItem.addSelectionListener(new bY(this));
    new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(ResourceTools.getMessage("ExitItem"));
    localMenuItem.addSelectionListener(new cj(this));
    return localMenu2;
  }

  private cA i()
  {
    return this.n;
  }

  private void j()
  {
    if ((i() != null) && (i().a().m().isFocusControl()))
      i().a().x();
    else if ((this.o != null) && (this.o.a().m().isFocusControl()))
      this.o.a().x();
  }

  private void k()
  {
    if ((i() != null) && (i().a().m().isFocusControl()))
      i().a().w();
    else if ((this.o != null) && (this.o.a().m().isFocusControl()))
      this.o.a().w();
  }

  private void l()
  {
    if ((i() != null) && (i().a().m().isFocusControl()))
      i().a().D();
    else if ((this.o != null) && (this.o.a().m().isFocusControl()))
      this.o.a().D();
  }

  private void m()
  {
    if ((i() != null) && (i().a().m().isFocusControl()))
      i().a().E();
    else if ((this.o != null) && (this.o.a().m().isFocusControl()))
      this.o.a().E();
  }

  private void n()
  {
    if ((i() != null) && (i().a().m().isFocusControl()))
      i().a().y();
    else if ((this.o != null) && (this.o.a().m().isFocusControl()))
      this.o.a().y();
    else if ((h() != null) && ((h().getData() instanceof TagType)))
    {
      if (MessageDialog.openQuestion(this.a, "", ResourceTools.formatMessage("to_delete", new String[] { h().getText() })))
      {
        ((TagType)h().getData()).dispose();
        this.p = true;
        h().dispose();
      }
    }
    else if ((h() != null) && ((h().getData() instanceof Tag)))
      if (MessageDialog.openQuestion(this.a, "", ResourceTools.formatMessage("to_delete", new String[] { h().getText() })))
      {
        ((Tag)h().getData()).dispose();
        h().dispose();
        this.p = true;
      }
  }

  private void o()
  {
    if ((i() != null) && (i().a().m().isFocusControl()))
      i().a().c();
    else if ((this.o != null) && (this.o.a().m().isFocusControl()))
      this.o.a().c();
  }

  private void p()
  {
    if ((i() != null) && (i().a().m().isFocusControl()))
      i().a().e();
    else if ((this.o != null) && (this.o.a().m().isFocusControl()))
      this.o.a().e();
  }

  private void q()
  {
    if ((h() != null) && ((h().getData() instanceof RspTags)))
    {
      cz localcz = new cz(this);
      if ((localcz.open() == 0) && (localcz.a().length() > 0))
      {
        g().addTagType(new TagType(localcz.a(), localcz.b()));
        this.p = true;
        v();
      }
    }
  }

  private void r()
  {
    if ((h() != null) && ((h().getData() instanceof TagType)))
    {
      cz localcz = new cz(this);
      if ((localcz.open() == 0) && (localcz.a().length() > 0))
      {
        Tag localTag = new Tag(localcz.a(), localcz.b());
        ((TagType)h().getData()).addTag(localTag);
        this.p = true;
        v();
        a(localTag);
      }
    }
  }

  private void s()
  {
    if ((h() != null) && ((h().getData() instanceof TagType)))
    {
      TagType localTagType = (TagType)h().getData();
      cz localcz = new cz(this, localTagType.getName(), localTagType.getDisName());
      if ((localcz.open() == 0) && ((!localcz.a().equals(localTagType.getName())) || (!localcz.b().equals(localTagType.getDisName()))))
      {
        localTagType.setName(localcz.a());
        localTagType.setDisName(localcz.b());
        this.p = true;
        v();
      }
    }
  }

  private void t()
  {
    if ((h() != null) && ((h().getData() instanceof Tag)))
    {
      Tag localTag = (Tag)h().getData();
      cz localcz = new cz(this, localTag.getName(), localTag.getDisName());
      if ((localcz.open() == 0) && ((!localcz.a().equals(localTag.getName())) || (!localcz.b().equals(localTag.getDisName()))))
      {
        localTag.setName(localcz.a());
        localTag.setDisName(localcz.b());
        this.p = true;
        v();
      }
    }
  }

  private String b(String paramString)
  {
    String str = ResourceTools.getMessage(paramString);
    if (str == null)
      return "";
    return str.replace('@', '\t');
  }

  Menu b()
  {
    Menu localMenu1 = this.a.getMenuBar();
    Menu localMenu2 = new Menu(localMenu1);
    MenuItem localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("UndoItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 90);
    localMenuItem.addSelectionListener(new cs(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("RedoItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 89);
    localMenuItem.addSelectionListener(new ct(this));
    new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("CutItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 88);
    localMenuItem.addSelectionListener(new cu(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("CopyItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 67);
    localMenuItem.addSelectionListener(new cv(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("PasteItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 86);
    localMenuItem.addSelectionListener(new cw(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("SelectAllItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 65);
    localMenuItem.addSelectionListener(new cx(this));
    localMenuItem = new MenuItem(localMenu2, 2);
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("AddTagItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 65);
    localMenuItem.addSelectionListener(new cy(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("ModifyItem"));
    localMenuItem.setAccelerator(SWT.MOD1 + 69);
    localMenuItem.addSelectionListener(new bZ(this));
    localMenuItem = new MenuItem(localMenu2, 8);
    localMenuItem.setText(b("DelItem"));
    localMenuItem.setAccelerator(127);
    localMenuItem.addSelectionListener(new ca(this));
    return localMenu2;
  }

  void c()
  {
    this.c = new ToolBar(this.a, 0);
    ToolItem localToolItem = new ToolItem(this.c, 8);
    localToolItem.setImage(ResourceTools.getImage("SaveItem.icon"));
    localToolItem.addSelectionListener(new cb(this));
    localToolItem = new ToolItem(this.c, 2);
    localToolItem = new ToolItem(this.c, 8);
    localToolItem.setImage(ResourceTools.getImage("undo.icon"));
    localToolItem.addSelectionListener(new cc(this));
    localToolItem = new ToolItem(this.c, 8);
    localToolItem.setImage(ResourceTools.getImage("redo.icon"));
    localToolItem.addSelectionListener(new cd(this));
    localToolItem = new ToolItem(this.c, 2);
    localToolItem = new ToolItem(this.c, 8);
    localToolItem.setImage(ResourceTools.getImage("cut.icon"));
    localToolItem.addSelectionListener(new ce(this));
    localToolItem = new ToolItem(this.c, 8);
    localToolItem.setImage(ResourceTools.getImage("copy.icon"));
    localToolItem.addSelectionListener(new cf(this));
    localToolItem = new ToolItem(this.c, 8);
    localToolItem.setImage(ResourceTools.getImage("paste.icon"));
    localToolItem.addSelectionListener(new cg(this));
  }

  void d()
  {
    Menu localMenu = new Menu(this.a, 2);
    this.a.setMenuBar(localMenu);
    MenuItem localMenuItem1 = new MenuItem(localMenu, 64);
    localMenuItem1.setText(b("FileMenu"));
    localMenuItem1.setMenu(a());
    MenuItem localMenuItem2 = new MenuItem(localMenu, 64);
    localMenuItem2.setText(b("EditMenu"));
    localMenuItem2.setMenu(b());
  }

  void a(Display paramDisplay)
  {
    this.a = new Shell(paramDisplay);
    this.a.setText(b("title.RspTagEditor"));
    GridLayout localGridLayout = new GridLayout();
    localGridLayout.numColumns = 1;
    this.a.setLayout(localGridLayout);
    this.a.addShellListener(new ch(this));
  }

  private void u()
  {
    Composite localComposite = new Composite(this.a, 0);
    localComposite.setLayout(h.a(1));
    localComposite.setLayoutData(new GridData(1808));
    this.i = new SashForm(localComposite, 256);
    this.i.setLayout(h.a(1));
    this.i.setLayoutData(new GridData(1808));
    this.e = new Composite(this.i, 2048);
    this.e.setBackground(h.d);
    this.e.setLayout(h.a(1));
    this.e.setLayoutData(new GridData(1808));
    CTabFolder localCTabFolder = new CTabFolder(this.e, 8389504);
    localCTabFolder.setLayoutData(new GridData(1808));
    CTabItem localCTabItem = new CTabItem(localCTabFolder, 0);
    localCTabItem.setText(b("tree.RspTagEditor"));
    localCTabItem.setControl(a(localCTabFolder));
    localCTabFolder.setSelection(localCTabItem);
    this.f = new Composite(this.i, 2048);
    this.f.setBackground(h.d);
    this.f.setLayout(h.a(1));
    this.f.setLayoutData(new GridData(1808));
    this.m = new CTabFolder(this.f, 8389504);
    this.m.setLayoutData(new GridData(1808));
    this.i.setWeights(new int[] { 20, 80 });
    v();
  }

  private void a(Tag paramTag)
  {
    if ((this.g.getItems() != null) && (this.g.getItems().length == 0))
    {
      TreeItem[] arrayOfTreeItem1 = this.g.getItems()[0].getItems();
      for (int i1 = 0; i1 < arrayOfTreeItem1.length; i1++)
      {
        TreeItem[] arrayOfTreeItem2 = arrayOfTreeItem1[i1].getItems();
        for (int i2 = 0; i2 < arrayOfTreeItem2.length; i2++)
        {
          if ((!(arrayOfTreeItem2[i2].getData() instanceof Tag)) || (!paramTag.equals(arrayOfTreeItem2[i2].getData())))
            continue;
          a(arrayOfTreeItem2[i2]);
          return;
        }
      }
    }
  }

  private Composite a(CTabFolder paramCTabFolder)
  {
    Composite localComposite = new Composite(paramCTabFolder, 0);
    localComposite.setLayout(new GridLayout());
    localComposite.setLayoutData(new GridData(1808));
    this.g = new s().a(localComposite, 2820);
    this.g.setLayoutData(new GridData(1808));
    this.g.addSelectionListener(new ci(this));
    this.g.addMouseListener(new ck(this));
    return localComposite;
  }

  private void a(TreeItem paramTreeItem)
  {
    if ((paramTreeItem != null) && (paramTreeItem.getData() != null) && ((paramTreeItem.getData() instanceof Tag)))
    {
      if ((i() != null) && (i().b().equals(paramTreeItem.getData())))
        return;
      if (this.k != null)
      {
        this.k.dispose();
        this.k = null;
      }
      if (this.l != null)
      {
        this.l.dispose();
        this.l = null;
      }
      this.k = new CTabItem(this.m, 0);
      this.k.setText(b("editor.RspTagEditor"));
      this.k.setControl(b((Tag)paramTreeItem.getData()));
      this.l = new CTabItem(this.m, 0);
      this.l.setText(b("postEditor.RspTagEditor"));
      this.l.setControl(c((Tag)paramTreeItem.getData()));
      this.m.setSelection(this.k);
    }
  }

  private Composite b(Tag paramTag)
  {
    if (this.r.get(paramTag) != null)
      return (Composite)this.r.get(paramTag);
    this.n = new cA(this, paramTag, this.m, true);
    this.r.put(paramTag, this.n.c());
    return this.n.c();
  }

  private Composite c(Tag paramTag)
  {
    if (this.s.get(paramTag) != null)
      return (Composite)this.s.get(paramTag);
    this.o = new cA(this, paramTag, this.m, false);
    this.s.put(paramTag, this.o.c());
    return this.o.c();
  }

  private void b(TreeItem paramTreeItem)
  {
    Object localObject;
    if ((h() != null) && ((h().getData() instanceof RspTags)))
    {
      if ((this.d != null) && (!this.d.isDisposed()))
        this.d.dispose();
      this.d = new Menu(this.a, 8);
      localObject = new MenuItem(this.d, 8);
      ((MenuItem)localObject).setText(ResourceTools.getMessage("addtype.RspTagEditor"));
      ((MenuItem)localObject).addSelectionListener(new cl(this));
      ((MenuItem)localObject).setAccelerator(SWT.MOD1 + 65);
      localObject = new MenuItem(this.d, 8);
      ((MenuItem)localObject).setText(ResourceTools.getMessage("delete.RspTagEditor"));
      ((MenuItem)localObject).addSelectionListener(new cm(this));
      ((MenuItem)localObject).setAccelerator(SWT.MOD1 + 68);
      this.d.setVisible(true);
    }
    else
    {
      MenuItem localMenuItem;
      if ((h() != null) && ((h().getData() instanceof TagType)))
      {
        localObject = new Menu(this.a, 8);
        localMenuItem = new MenuItem((Menu)localObject, 8);
        localMenuItem.setText(ResourceTools.getMessage("addtag.RspTagEditor"));
        localMenuItem.addSelectionListener(new cn(this));
        localMenuItem.setAccelerator(SWT.MOD1 + 65);
        localMenuItem = new MenuItem((Menu)localObject, 8);
        localMenuItem.setText(ResourceTools.getMessage("delete.RspTagEditor"));
        localMenuItem.addSelectionListener(new co(this));
        localMenuItem.setAccelerator(SWT.MOD1 + 68);
        localMenuItem = new MenuItem((Menu)localObject, 8);
        localMenuItem.setText(ResourceTools.getMessage("property.RspTagEditor"));
        localMenuItem.addSelectionListener(new cp(this));
        localMenuItem.setAccelerator(SWT.MOD1 + 80);
        ((Menu)localObject).setVisible(true);
      }
      else if ((h() != null) && ((h().getData() instanceof Tag)))
      {
        localObject = new Menu(this.a, 8);
        localMenuItem = new MenuItem((Menu)localObject, 8);
        localMenuItem.setText(ResourceTools.getMessage("delete.RspTagEditor"));
        localMenuItem.addSelectionListener(new cq(this));
        localMenuItem.setAccelerator(SWT.MOD1 + 68);
        localMenuItem = new MenuItem((Menu)localObject, 8);
        localMenuItem.setText(ResourceTools.getMessage("property.RspTagEditor"));
        localMenuItem.addSelectionListener(new cr(this));
        localMenuItem.setAccelerator(SWT.MOD1 + 80);
        ((Menu)localObject).setVisible(true);
      }
    }
  }

  private void v()
  {
    this.g.removeAll();
    TreeItem localTreeItem = new TreeItem(this.g, 0);
    localTreeItem.setData(g());
    localTreeItem.setText(ResourceTools.getMessage("rsptags.RspTagEditor"));
    localTreeItem.setImage(ResourceTools.getImage("export.icon"));
    List localList = g().getTagTypes();
    for (int i1 = 0; i1 < localList.size(); i1++)
      a(localTreeItem, (TagType)localList.get(i1));
    localTreeItem.setExpanded(true);
  }

  private void a(TreeItem paramTreeItem, TagType paramTagType)
  {
    TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
    localTreeItem.setData(paramTagType);
    localTreeItem.setText(paramTagType.getDisName());
    localTreeItem.setImage(ResourceTools.getImage("export.icon"));
    List localList = paramTagType.getTags();
    for (int i1 = 0; i1 < localList.size(); i1++)
      a(localTreeItem, (Tag)localList.get(i1));
    localTreeItem.setExpanded(true);
  }

  private void a(TreeItem paramTreeItem, Tag paramTag)
  {
    TreeItem localTreeItem = new TreeItem(paramTreeItem, 0);
    localTreeItem.setData(paramTag);
    localTreeItem.setText(paramTag.getDisName());
    localTreeItem.setImage(ResourceTools.getImage("exportcompile.icon"));
  }

  void a(String paramString)
  {
    MessageBox localMessageBox = new MessageBox(this.a, 1);
    localMessageBox.setMessage(paramString);
    localMessageBox.open();
  }

  public Shell b(Display paramDisplay)
  {
    a(paramDisplay);
    d();
    c();
    u();
    this.a.setSize(800, 600);
    this.a.open();
    return this.a;
  }

  void e()
  {
    try
    {
      if (g() == null)
        return;
      this.q.save();
      this.p = false;
    }
    catch (IOException localIOException)
    {
      String str = MessageFormat.format(b("Err_file_io"), new String[] { this.b });
      a(str);
      return;
    }
  }

  void f()
  {
    this.a.close();
  }

  public RspTags g()
  {
    return this.q;
  }

  public TreeItem h()
  {
    if ((this.g != null) && (this.g.getSelection() != null) && (this.g.getSelection().length > 0))
      return this.g.getSelection()[0];
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.shell.bX
 * JD-Core Version:    0.6.0
 */
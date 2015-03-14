define search_byte
    if $argc != 3
        help search_byte
    else
        set $begin_addr = $arg0
        set $end_addr = $arg1

        while $begin_addr <= $end_addr
            if *((unsigned char*)$begin_addr) == $arg2
                printf "Find it！The address is 0x%x\n", $begin_addr
                loop_break
            else
                set $begin_addr = $begin_addr + 1
            end
        end

        if $begin_addr > $end_addr
            printf "Can't find it!\n"
        end
    end
end

document search_byte
    search a specified byte value(0 ~ 255) during a memory
    usage: search_byte begin_addr end_addr byte
end
